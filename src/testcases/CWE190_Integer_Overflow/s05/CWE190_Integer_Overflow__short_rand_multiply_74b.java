/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_rand_multiply_74b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s05;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_rand_multiply_74b
{
    public void badSink(HashMap<Integer,Short> dataHashMap ) throws Throwable
    {
        short data = dataHashMap.get(2);

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Short.MAX_VALUE, this will overflow */
            short result = (short)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(HashMap<Integer,Short> dataHashMap ) throws Throwable
    {
        short data = dataHashMap.get(2);

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Short.MAX_VALUE, this will overflow */
            short result = (short)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(HashMap<Integer,Short> dataHashMap ) throws Throwable
    {
        short data = dataHashMap.get(2);

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < (Short.MAX_VALUE/2))
            {
                short result = (short)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform multiplication.");
            }
        }

    }
}
