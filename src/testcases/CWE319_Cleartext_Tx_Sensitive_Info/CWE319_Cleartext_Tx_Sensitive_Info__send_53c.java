/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_53c.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_53c
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__send_53d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__send_53d()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__send_53d()).goodB2GSink(data );
    }
}
