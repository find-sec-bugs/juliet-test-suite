/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_74b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: connect_tcp Read password using an outbound tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;
import java.util.HashMap;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_74b
{
    public void badSink(HashMap<Integer,String> passwordHashMap ) throws Throwable
    {
        String password = passwordHashMap.get(2);

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(HashMap<Integer,String> passwordHashMap ) throws Throwable
    {
        String password = passwordHashMap.get(2);

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(HashMap<Integer,String> passwordHashMap ) throws Throwable
    {
        String password = passwordHashMap.get(2);

        if (password != null)
        {
            /* FIX: Decrypt password before using in PasswordAuthentication() */
            {
                Cipher aesCipher = Cipher.getInstance("AES");
                /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                password = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
            }
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }
}
