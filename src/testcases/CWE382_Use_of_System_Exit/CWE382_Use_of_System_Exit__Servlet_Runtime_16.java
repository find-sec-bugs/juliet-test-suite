/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_Runtime_16.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks: Runtime
*    GoodSink: notify user, do not use Runtime.getRuntime.exit
*    BadSink : calling Runtime.getRuntime.exit, breaching best practices
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE382_Use_of_System_Exit__Servlet_Runtime_16 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        while(true)
        {
            /* FLAW: use of Runtime.getRuntime.exit */
            Runtime.getRuntime().exit(1);
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        while(true)
        {
            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");
            break;
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
