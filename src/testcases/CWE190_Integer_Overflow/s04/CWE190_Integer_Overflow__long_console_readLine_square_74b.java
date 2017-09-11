/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_console_readLine_square_74b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s04;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_console_readLine_square_74b
{
    public void badSink(HashMap<Integer,Long> dataHashMap ) throws Throwable
    {
        long data = dataHashMap.get(2);

        /* POTENTIAL FLAW: if (data*data) > Long.MAX_VALUE, this will overflow */
        long result = (long)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(HashMap<Integer,Long> dataHashMap ) throws Throwable
    {
        long data = dataHashMap.get(2);

        /* POTENTIAL FLAW: if (data*data) > Long.MAX_VALUE, this will overflow */
        long result = (long)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(HashMap<Integer,Long> dataHashMap ) throws Throwable
    {
        long data = dataHashMap.get(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
        if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Long.MAX_VALUE)))
        {
            long result = (long)(data * data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform squaring.");
        }

    }
}
