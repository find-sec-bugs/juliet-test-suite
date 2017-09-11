/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_Environment_add_81_bad.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_Environment_add_81_bad extends CWE190_Integer_Overflow__int_Environment_add_81_base
{
    public void action(int data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
        int result = (int)(data + 1);

        IO.writeLine("result: " + result);

    }
}
