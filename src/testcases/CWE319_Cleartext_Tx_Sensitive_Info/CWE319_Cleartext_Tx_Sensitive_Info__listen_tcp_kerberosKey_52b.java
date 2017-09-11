/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_52b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: kerberosKey
 *    GoodSink: Decrypt password before using in KerberosKey()
 *    BadSink : Use password directly in KerberosKey()
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_52b
{
    public void badSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_52c()).badSink(password );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_52c()).goodG2BSink(password );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_52c()).goodB2GSink(password );
    }
}
