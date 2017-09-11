/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_System_15.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks: System
*    GoodSink: notify user, do not use System.exit
*    BadSink : calling System.exit, breaching best practices
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE382_Use_of_System_Exit__Servlet_System_15 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch (7)
        {
        case 7:
            /* FLAW: use of System.exit */
            System.exit(1);
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
            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");
            break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch (7)
        {
        case 7:
            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");
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
