/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_min_multiply_61b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;

public class CWE191_Integer_Underflow__long_min_multiply_61b
{
    public long badSource() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Long.MIN_VALUE;

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public long goodG2BSource() throws Throwable
    {
        long data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public long goodB2GSource() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Long.MIN_VALUE;

        return data;
    }
}
