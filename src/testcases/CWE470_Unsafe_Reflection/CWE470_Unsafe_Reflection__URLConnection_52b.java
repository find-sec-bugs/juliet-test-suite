/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__URLConnection_52b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__URLConnection_52b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__URLConnection_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__URLConnection_52c()).goodG2BSink(data );
    }
}
