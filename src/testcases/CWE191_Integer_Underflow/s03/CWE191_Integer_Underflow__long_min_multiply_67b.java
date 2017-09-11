/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_min_multiply_67b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;

public class CWE191_Integer_Underflow__long_min_multiply_67b
{
    public void badSink(CWE191_Integer_Underflow__long_min_multiply_67a.Container dataContainer ) throws Throwable
    {
        long data = dataContainer.containerOne;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
            long result = (long)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE191_Integer_Underflow__long_min_multiply_67a.Container dataContainer ) throws Throwable
    {
        long data = dataContainer.containerOne;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
            long result = (long)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(CWE191_Integer_Underflow__long_min_multiply_67a.Container dataContainer ) throws Throwable
    {
        long data = dataContainer.containerOne;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* FIX: Add a check to prevent an underflow from occurring */
            if (data > (Long.MIN_VALUE/2))
            {
                long result = (long)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform multiplication.");
            }
        }

    }
}
