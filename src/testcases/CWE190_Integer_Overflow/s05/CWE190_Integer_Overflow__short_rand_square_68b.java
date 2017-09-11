/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_rand_square_68b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s05;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_rand_square_68b
{
    public void badSink() throws Throwable
    {
        short data = CWE190_Integer_Overflow__short_rand_square_68a.data;

        /* POTENTIAL FLAW: if (data*data) > Short.MAX_VALUE, this will overflow */
        short result = (short)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        short data = CWE190_Integer_Overflow__short_rand_square_68a.data;

        /* POTENTIAL FLAW: if (data*data) > Short.MAX_VALUE, this will overflow */
        short result = (short)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        short data = CWE190_Integer_Overflow__short_rand_square_68a.data;

        /* FIX: Add a check to prevent an overflow from occurring */
        /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
        if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Short.MAX_VALUE)))
        {
            short result = (short)(data * data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform squaring.");
        }

    }
}
