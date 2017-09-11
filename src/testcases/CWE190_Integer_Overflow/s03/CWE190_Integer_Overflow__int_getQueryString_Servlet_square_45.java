/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getQueryString_Servlet_square_45.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow.s03;
import testcasesupport.*;

import javax.servlet.http.*;


import java.util.StringTokenizer;
import java.util.logging.Level;

public class CWE190_Integer_Overflow__int_getQueryString_Servlet_square_45 extends AbstractTestCaseServlet
{
    private int dataBad;
    private int dataGoodG2B;
    private int dataGoodB2G;

    private void badSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = dataBad;

        /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
        int result = (int)(data * data);

        IO.writeLine("result: " + result);

    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
        {
            StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");

            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken(); /* a token will be like "id=33" */
                if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                {
                    try
                    {
                        data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                    }
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception reading id from query string", exceptNumberFormat);
                    }
                    break; /* exit while loop */
                }
            }
        }

        dataBad = data;
        badSink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2BSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = dataGoodG2B;

        /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
        int result = (int)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        dataGoodG2B = data;
        goodG2BSink(request, response);
    }

    private void goodB2GSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = dataGoodB2G;

        /* FIX: Add a check to prevent an overflow from occurring */
        /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
        if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
        {
            int result = (int)(data * data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform squaring.");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
        {
            StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");

            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken(); /* a token will be like "id=33" */
                if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                {
                    try
                    {
                        data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                    }
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception reading id from query string", exceptNumberFormat);
                    }
                    break; /* exit while loop */
                }
            }
        }

        dataGoodB2G = data;
        goodB2GSink(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
