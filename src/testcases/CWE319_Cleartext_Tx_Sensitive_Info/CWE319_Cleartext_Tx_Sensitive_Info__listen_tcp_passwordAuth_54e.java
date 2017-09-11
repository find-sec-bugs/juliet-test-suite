/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_passwordAuth_54e.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-54e.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_passwordAuth_54e
{
    public void badSink(String password ) throws Throwable
    {

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String password ) throws Throwable
    {

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String password ) throws Throwable
    {

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
