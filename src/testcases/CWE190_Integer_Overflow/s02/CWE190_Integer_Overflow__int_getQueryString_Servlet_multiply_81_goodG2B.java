/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_81_goodG2B.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_81_goodG2B extends CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_81_base
{
    public void action(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }
}
