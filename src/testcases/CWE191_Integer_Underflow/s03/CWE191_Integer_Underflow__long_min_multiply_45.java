/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_min_multiply_45.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;

public class CWE191_Integer_Underflow__long_min_multiply_45 extends AbstractTestCase
{
    private long dataBad;
    private long dataGoodG2B;
    private long dataGoodB2G;

    private void badSink() throws Throwable
    {
        long data = dataBad;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
            long result = (long)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    public void bad() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Long.MIN_VALUE;

        dataBad = data;
        badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink() throws Throwable
    {
        long data = dataGoodG2B;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
            long result = (long)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        long data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        dataGoodG2B = data;
        goodG2BSink();
    }

    private void goodB2GSink() throws Throwable
    {
        long data = dataGoodB2G;

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Long.MIN_VALUE;

        dataGoodB2G = data;
        goodB2GSink();
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
