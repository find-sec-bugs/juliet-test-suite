/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_53c.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: URLConnection Read password from a web server with URLConnection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

public class CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_53c
{
    public void badSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_53d()).badSink(password );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_53d()).goodG2BSink(password );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_53d()).goodB2GSink(password );
    }
}
