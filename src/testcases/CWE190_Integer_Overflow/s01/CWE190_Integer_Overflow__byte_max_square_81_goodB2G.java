/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_max_square_81_goodB2G.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for byte
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_max_square_81_goodB2G extends CWE190_Integer_Overflow__byte_max_square_81_base
{
    public void action(byte data ) throws Throwable
    {

        /* FIX: Add a check to prevent an overflow from occurring */
        /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
        if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Byte.MAX_VALUE)))
        {
            byte result = (byte)(data * data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform squaring.");
        }

    }
}
