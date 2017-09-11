/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_rand_multiply_54b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-54b.tmpl.java
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

public class CWE191_Integer_Underflow__short_rand_multiply_54b
{
    public void badSink(short data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__short_rand_multiply_54c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(short data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__short_rand_multiply_54c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(short data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__short_rand_multiply_54c()).goodB2GSink(data );
    }
}
