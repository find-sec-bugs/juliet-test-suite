/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_kerberosKey_81_goodB2G.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: connect_tcp Read password using an outbound tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: kerberosKey
 *    GoodSink: Decrypt password before using in KerberosKey()
 *    BadSink : Use password directly in KerberosKey()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_kerberosKey_81_goodB2G extends CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_kerberosKey_81_base
{
    public void action(String password ) throws Throwable
    {

        if (password != null)
        {
            KerberosPrincipal principal = new KerberosPrincipal("test");
            /* FIX: Decrypt password before using in KerberosKey() */
            {
                Cipher aesCipher = Cipher.getInstance("AES");
                /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                password = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
            }
            KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
            IO.writeLine(key.toString());
        }

    }
}
