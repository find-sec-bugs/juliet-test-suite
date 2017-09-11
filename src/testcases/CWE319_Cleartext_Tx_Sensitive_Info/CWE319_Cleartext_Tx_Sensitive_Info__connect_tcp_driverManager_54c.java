/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_54c.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: connect_tcp Read password using an outbound tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_54c
{
    public void badSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_54d()).badSink(password );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_54d()).goodG2BSink(password );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_54d()).goodB2GSink(password );
    }
}
