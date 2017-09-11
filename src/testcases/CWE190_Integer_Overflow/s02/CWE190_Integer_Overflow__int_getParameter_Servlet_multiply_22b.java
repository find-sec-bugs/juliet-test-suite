/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getParameter_Servlet_multiply_22b.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE190_Integer_Overflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_getParameter_Servlet_multiply_22b
{
    public void badSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE190_Integer_Overflow__int_getParameter_Servlet_multiply_22a.badPublicStatic)
        {
            if(data > 0) /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1Sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE190_Integer_Overflow__int_getParameter_Servlet_multiply_22a.goodB2G1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }
        else
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

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2Sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE190_Integer_Overflow__int_getParameter_Servlet_multiply_22a.goodB2G2PublicStatic)
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE190_Integer_Overflow__int_getParameter_Servlet_multiply_22a.goodG2BPublicStatic)
        {
            if(data > 0) /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }
    }
}
