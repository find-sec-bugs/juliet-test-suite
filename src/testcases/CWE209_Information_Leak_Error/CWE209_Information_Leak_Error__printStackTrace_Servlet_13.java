/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_Servlet_13.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-13.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace_Servlet
*    GoodSink: Print a generic error message to response
*    BadSink : Print stack trace to response
* Flow Variant: 13 Control flow: if(IO.STATIC_FINAL_FIVE==5) and if(IO.STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__printStackTrace_Servlet_13 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE == 5)
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
    }

    /* good1() changes IO.STATIC_FINAL_FIVE==5 to IO.STATIC_FINAL_FIVE!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
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
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE == 5)
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
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
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
