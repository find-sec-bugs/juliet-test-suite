/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getParameter_Servlet_square_54d.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_getParameter_Servlet_square_54d
{
    public void badSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_getParameter_Servlet_square_54e()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_getParameter_Servlet_square_54e()).goodG2BSink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_getParameter_Servlet_square_54e()).goodB2GSink(data , request, response);
    }
}
