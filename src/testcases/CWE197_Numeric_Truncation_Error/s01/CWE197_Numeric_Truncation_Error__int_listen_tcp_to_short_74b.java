/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__int_listen_tcp_to_short_74b.java
Label Definition File: CWE197_Numeric_Truncation_Error__int.label.xml
Template File: sources-sink-74b.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_short
 *    BadSink : Convert data to a short
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s01;
import testcasesupport.*;
import java.util.HashMap;

public class CWE197_Numeric_Truncation_Error__int_listen_tcp_to_short_74b
{
    public void badSink(HashMap<Integer,Integer> dataHashMap ) throws Throwable
    {
        int data = dataHashMap.get(2);

        {
            /* POTENTIAL FLAW: Convert data to a short, possibly causing a truncation error */
            IO.writeLine((short)data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(HashMap<Integer,Integer> dataHashMap ) throws Throwable
    {
        int data = dataHashMap.get(2);

        {
            /* POTENTIAL FLAW: Convert data to a short, possibly causing a truncation error */
            IO.writeLine((short)data);
        }

    }
}
