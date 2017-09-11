/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_61b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;

import java.net.PasswordAuthentication;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_61b
{
    public String badSource() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication credentials = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(credentials.getPassword());

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2BSource() throws Throwable
    {
        String data;

        /* FIX: Use a regular string (non-sensitive string) */
        data = "Hello World";

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public String goodB2GSource() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication credentials = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(credentials.getPassword());

        return data;
    }
}
