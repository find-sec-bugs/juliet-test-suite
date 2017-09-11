/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__connect_tcp_54d.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-54d.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__connect_tcp_54d
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__connect_tcp_54e()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__connect_tcp_54e()).goodG2BSink(data );
    }
}
