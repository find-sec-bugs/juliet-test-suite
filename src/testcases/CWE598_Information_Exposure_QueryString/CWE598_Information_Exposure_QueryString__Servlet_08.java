/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE598_Information_Exposure_QueryString__Servlet_08.java
Label Definition File: CWE598_Information_Exposure_QueryString__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 598 Information Exposure Through Query Strings in GET Request
* Sinks:
*    GoodSink: post password field
*    BadSink : get password field
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */

package testcases.CWE598_Information_Exposure_QueryString;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE598_Information_Exposure_QueryString__Servlet_08 extends AbstractTestCaseServlet
{
    /* The methods below always return the same value, so a tool
     * should be able to figure out that every call to these
     * methods will return true or return false.
     */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateReturnsTrue())
        {
            response.getWriter().println("<form id=\"form\" name=\"form\" method=\"get\" action=\"password-test-servlet\">"); /* FLAW: method should be post instead of get */
            response.getWriter().println("Username: <input name=\"username\" type=\"text\" tabindex=\"10\" /><br><br>");
            response.getWriter().println("Password: <input name=\"password\" type=\"password\" tabindex=\"10\" />");
            response.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Login-bad\" /></form>");
        }
    }

    /* good1() changes privateReturnsTrue() to privateReturnsFalse() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            response.getWriter().println("<form id=\"form\" name=\"form\" method=\"post\" action=\"password-test-servlet\">"); /* FIX: method set to post */

            response.getWriter().println("Username: <input name=\"username\" type=\"text\" tabindex=\"10\" /><br><br>");
            response.getWriter().println("Password: <input name=\"password\" type=\"password\" tabindex=\"10\" />");
            response.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Login-good\" /></form>");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateReturnsTrue())
        {
            response.getWriter().println("<form id=\"form\" name=\"form\" method=\"post\" action=\"password-test-servlet\">"); /* FIX: method set to post */
            response.getWriter().println("Username: <input name=\"username\" type=\"text\" tabindex=\"10\" /><br><br>");
            response.getWriter().println("Password: <input name=\"password\" type=\"password\" tabindex=\"10\" />");
            response.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Login-good\" /></form>");
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
