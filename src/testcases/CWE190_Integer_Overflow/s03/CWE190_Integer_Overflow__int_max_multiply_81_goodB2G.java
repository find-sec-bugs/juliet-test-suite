/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_max_multiply_81_goodB2G.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the maximum value for int
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow.s03;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_max_multiply_81_goodB2G extends CWE190_Integer_Overflow__int_max_multiply_81_base
{
    public void action(int data ) throws Throwable
    {

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < (Integer.MAX_VALUE/2))
            {
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform multiplication.");
            }
        }

    }
}
