/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE549_Missing_Password_Masking__Servlet_01.java
Label Definition File: CWE549_Missing_Password_Masking__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 549 Passwords should be masked during entry to prevent others from stealing them
* Sinks:
*    GoodSink: password field masked
*    BadSink : password field unmasked
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE549_Missing_Password_Masking;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE549_Missing_Password_Masking__Servlet_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        response.getWriter().println("<form id=\"form\" name=\"form\" method=\"post\" action=\"password-test-servlet\">");
        response.getWriter().println("Username: <input name=\"username\" type=\"text\" tabindex=\"10\" /><br><br>");
        /* FLAW: password field should be masked (type="text") */
        response.getWriter().println("Password: <input name=\"password\" type=\"text\" tabindex=\"10\" />");
        response.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Login-bad\" /></form>");

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        response.getWriter().println("<form id=\"form\" name=\"form\" method=\"post\" action=\"password-test-servlet\">");
        response.getWriter().println("Username: <input name=\"username\" type=\"text\" tabindex=\"10\" /><br><br>");
        /* FIX: password field is masked with type="password" instead of type="text" */
        response.getWriter().println("Password: <input name=\"password\" type=\"password\" tabindex=\"10\" />");
        response.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Login-good\" /></form>");

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

