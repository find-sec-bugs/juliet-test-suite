/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_rand_multiply_52b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_rand_multiply_52b
{
    public void badSink(byte data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__byte_rand_multiply_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(byte data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__byte_rand_multiply_52c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(byte data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__byte_rand_multiply_52c()).goodB2GSink(data );
    }
}
