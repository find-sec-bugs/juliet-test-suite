/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE698_Redirect_Without_Exit__Servlet_12.java
Label Definition File: CWE698_Redirect_Without_Exit__Servlet.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 698 Redirect Without Exit
* Sinks:
*    GoodSink: return after redirect
*    BadSink : perform actions after redirect
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE698_Redirect_Without_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE698_Redirect_Without_Exit__Servlet_12 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            response.sendRedirect("/test");
            /* FLAW: code after the redirect is undefined */
            IO.writeLine("doing some more things here after the redirect");
        }
        else
        {

            response.sendRedirect("/test");
            /* FIX: no code after the redirect */

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            response.sendRedirect("/test");
            /* FIX: no code after the redirect */
        }
        else
        {

            response.sendRedirect("/test");
            /* FIX: no code after the redirect */

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
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
