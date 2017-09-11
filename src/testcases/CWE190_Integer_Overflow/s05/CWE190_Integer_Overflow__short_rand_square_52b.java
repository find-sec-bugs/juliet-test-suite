/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_rand_square_52b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s05;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_rand_square_52b
{
    public void badSink(short data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__short_rand_square_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(short data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__short_rand_square_52c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(short data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__short_rand_square_52c()).goodB2GSink(data );
    }
}
