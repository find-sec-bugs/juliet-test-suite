/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_passwordAuth_81_goodG2B.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_passwordAuth_81_goodG2B extends CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_passwordAuth_81_base
{
    public void action(String password ) throws Throwable
    {

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }
}
