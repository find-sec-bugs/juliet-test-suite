/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE533_Info_Exposure_Server_Log__Servlet_01.java
Label Definition File: CWE533_Info_Exposure_Server_Log__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 533 Information Exposure through Server Log Files
* Sinks:
*    GoodSink: log non-sensitive information to the server log
*    BadSink : Expose the session ID to the server log
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE533_Info_Exposure_Server_Log;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE533_Info_Exposure_Server_Log__Servlet_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (request.getParameter("username") == null)
        {
            return;
        }

        String username = request.getParameter("username");

        if (username.matches("[a-zA-Z0-9]*"))
        {
            HttpSession session = request.getSession(true);
            /* FLAW: Expose the session ID to server log */
            log("Username: " + username + " Session ID:" + session.getId());
        }
        else
        {
            response.getWriter().println("Invalid characters");
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (request.getParameter("username") == null)
        {
            return;
        }

        String username = request.getParameter("username");

        if (username.matches("[a-zA-Z0-9]*"))
        {
            /* FIX: logged message does not contain session id */
            log("Username: " + username + " logged in");
        }
        else
        {
            response.getWriter().println("Invalid characters");
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

