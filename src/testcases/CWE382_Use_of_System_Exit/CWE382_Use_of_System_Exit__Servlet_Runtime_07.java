/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_Runtime_07.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks: Runtime
*    GoodSink: notify user, do not use Runtime.getRuntime.exit
*    BadSink : calling Runtime.getRuntime.exit, breaching best practices
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE382_Use_of_System_Exit__Servlet_Runtime_07 extends AbstractTestCaseServlet
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateFive == 5)
        {
            /* FLAW: use of Runtime.getRuntime.exit */
            Runtime.getRuntime().exit(1);
        }
    }

    /* good1() changes privateFive==5 to privateFive!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateFive != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateFive == 5)
        {
            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");
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
