/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getParameter_Servlet_square_81_goodG2B.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_getParameter_Servlet_square_81_goodG2B extends CWE190_Integer_Overflow__int_getParameter_Servlet_square_81_base
{
    public void action(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
        int result = (int)(data * data);

        IO.writeLine("result: " + result);

    }
}
