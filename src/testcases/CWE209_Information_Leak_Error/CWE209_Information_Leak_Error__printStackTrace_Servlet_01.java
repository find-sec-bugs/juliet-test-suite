/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_Servlet_01.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace_Servlet
*    GoodSink: Print a generic error message to response
*    BadSink : Print stack trace to response
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__printStackTrace_Servlet_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        try
        {
            throw new UnsupportedOperationException();
        }
        catch (UnsupportedOperationException exceptUnsupportedOperation)
        {
            exceptUnsupportedOperation.printStackTrace(response.getWriter()); /* FLAW: Print stack trace in response on error */
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        try
        {
            throw new UnsupportedOperationException();
        }
        catch (UnsupportedOperationException exceptUnsupportedOperation)
        {
            response.getWriter().println("There was an unsupported operation error"); /* FIX: print a generic error message to response */
        }

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

