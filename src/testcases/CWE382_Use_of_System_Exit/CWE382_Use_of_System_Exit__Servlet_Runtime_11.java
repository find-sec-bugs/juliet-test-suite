/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_Runtime_11.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks: Runtime
*    GoodSink: notify user, do not use Runtime.getRuntime.exit
*    BadSink : calling Runtime.getRuntime.exit, breaching best practices
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE382_Use_of_System_Exit__Servlet_Runtime_11 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrue())
        {
            /* FLAW: use of Runtime.getRuntime.exit */
            Runtime.getRuntime().exit(1);
        }
    }

    /* good1() changes IO.staticReturnsTrue() to IO.staticReturnsFalse() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsFalse())
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
        if (IO.staticReturnsTrue())
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
