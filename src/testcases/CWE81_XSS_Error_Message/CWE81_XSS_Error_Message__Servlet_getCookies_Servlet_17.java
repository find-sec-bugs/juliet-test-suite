/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE81_XSS_Error_Message__Servlet_getCookies_Servlet_17.java
Label Definition File: CWE81_XSS_Error_Message__Servlet.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 81 Cross Site Scripting (XSS) in Error Message
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded string
* BadSink: sendErrorServlet XSS in sendError
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE81_XSS_Error_Message;

import testcasesupport.*;

import javax.servlet.http.*;


public class CWE81_XSS_Error_Message__Servlet_getCookies_Servlet_17 extends AbstractTestCaseServlet
{
    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                data = cookieSources[0].getValue();
            }
        }

        for (int i = 0; i < 1; i++)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client;
                * The built-in J2EE server automatically does some HTML entity encoding.
                * Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
                */
                response.sendError(404, "<br>bad() - Parameter name has value " + data);
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
     * for statement with the one in the for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        for (int i = 0; i < 1; i++)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client;
                * The built-in J2EE server automatically does some HTML entity encoding.
                * Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
                */
                response.sendError(404, "<br>bad() - Parameter name has value " + data);
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
