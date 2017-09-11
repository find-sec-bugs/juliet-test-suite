/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__int_connect_tcp_to_short_52b.java
Label Definition File: CWE197_Numeric_Truncation_Error__int.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_short
 *    BadSink : Convert data to a short
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s01;
import testcasesupport.*;

public class CWE197_Numeric_Truncation_Error__int_connect_tcp_to_short_52b
{
    public void badSink(int data ) throws Throwable
    {
        (new CWE197_Numeric_Truncation_Error__int_connect_tcp_to_short_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data ) throws Throwable
    {
        (new CWE197_Numeric_Truncation_Error__int_connect_tcp_to_short_52c()).goodG2BSink(data );
    }
}
