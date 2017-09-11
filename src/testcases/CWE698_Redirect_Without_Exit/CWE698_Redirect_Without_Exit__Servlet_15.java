/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE698_Redirect_Without_Exit__Servlet_15.java
Label Definition File: CWE698_Redirect_Without_Exit__Servlet.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 698 Redirect Without Exit
* Sinks:
*    GoodSink: return after redirect
*    BadSink : perform actions after redirect
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE698_Redirect_Without_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE698_Redirect_Without_Exit__Servlet_15 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch (7)
        {
        case 7:
            response.sendRedirect("/test");
            /* FLAW: code after the redirect is undefined */
            IO.writeLine("doing some more things here after the redirect");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch (8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        default:
            response.sendRedirect("/test");
            /* FIX: no code after the redirect */
            break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch (7)
        {
        case 7:
            response.sendRedirect("/test");
            /* FIX: no code after the redirect */
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
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
