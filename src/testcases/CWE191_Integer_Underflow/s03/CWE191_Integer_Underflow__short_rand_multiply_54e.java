/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_rand_multiply_54e.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-54e.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;

public class CWE191_Integer_Underflow__short_rand_multiply_54e
{
    public void badSink(short data ) throws Throwable
    {

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Short.MIN_VALUE, this will underflow */
            short result = (short)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(short data ) throws Throwable
    {

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Short.MIN_VALUE, this will underflow */
            short result = (short)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(short data ) throws Throwable
    {

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* FIX: Add a check to prevent an underflow from occurring */
            if (data > (Short.MIN_VALUE/2))
            {
                short result = (short)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform multiplication.");
            }
        }

    }
}
