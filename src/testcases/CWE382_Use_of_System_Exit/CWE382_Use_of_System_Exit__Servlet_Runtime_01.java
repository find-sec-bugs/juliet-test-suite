/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_Runtime_01.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks: Runtime
*    GoodSink: notify user, do not use Runtime.getRuntime.exit
*    BadSink : calling Runtime.getRuntime.exit, breaching best practices
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE382_Use_of_System_Exit__Servlet_Runtime_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: use of Runtime.getRuntime.exit */
        Runtime.getRuntime().exit(1);

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: fail safe */
        response.getWriter().write("You cannot shut down this application, only the admin can");

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

