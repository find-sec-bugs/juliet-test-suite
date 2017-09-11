/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_68b.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_68b
{
    public void badSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_68a.data;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Integer.MIN_VALUE, this will underflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_68a.data;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Integer.MIN_VALUE, this will underflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_68a.data;

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* FIX: Add a check to prevent an underflow from occurring */
            if (data > (Integer.MIN_VALUE/2))
            {
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform multiplication.");
            }
        }

    }
}
