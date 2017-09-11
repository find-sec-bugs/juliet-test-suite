/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_rand_add_51b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s05;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_rand_add_51b
{
    public void badSink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        short result = (short)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        short result = (short)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(short data ) throws Throwable
    {

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Short.MAX_VALUE)
        {
            short result = (short)(data + 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform addition.");
        }

    }
}
