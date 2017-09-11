/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__int_Environment_to_short_66b.java
Label Definition File: CWE197_Numeric_Truncation_Error__int.label.xml
Template File: sources-sink-66b.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_short
 *    BadSink : Convert data to a short
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s01;
import testcasesupport.*;

public class CWE197_Numeric_Truncation_Error__int_Environment_to_short_66b
{
    public void badSink(int dataArray[] ) throws Throwable
    {
        int data = dataArray[2];

        {
            /* POTENTIAL FLAW: Convert data to a short, possibly causing a truncation error */
            IO.writeLine((short)data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int dataArray[] ) throws Throwable
    {
        int data = dataArray[2];

        {
            /* POTENTIAL FLAW: Convert data to a short, possibly causing a truncation error */
            IO.writeLine((short)data);
        }

    }
}
