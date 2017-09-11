/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_68b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: connect_tcp Read password using an outbound tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_68b
{
    public void badSink() throws Throwable
    {
        String password = CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_68a.password;

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        String password = CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_68a.password;

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        String password = CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_68a.password;

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
