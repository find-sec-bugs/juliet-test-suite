/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE698_Redirect_Without_Exit__Servlet_17.java
Label Definition File: CWE698_Redirect_Without_Exit__Servlet.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 698 Redirect Without Exit
* Sinks:
*    GoodSink: return after redirect
*    BadSink : perform actions after redirect
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE698_Redirect_Without_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE698_Redirect_Without_Exit__Servlet_17 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int j = 0; j < 1; j++)
        {
            response.sendRedirect("/test");
            /* FLAW: code after the redirect is undefined */
            IO.writeLine("doing some more things here after the redirect");
        }
    }

    /* good1() use the GoodSinkBody in the for statement */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int k = 0; k < 1; k++)
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
