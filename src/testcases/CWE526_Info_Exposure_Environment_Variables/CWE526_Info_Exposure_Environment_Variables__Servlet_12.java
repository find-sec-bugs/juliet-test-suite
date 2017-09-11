/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE526_Info_Exposure_Environment_Variables__Servlet_12.java
Label Definition File: CWE526_Info_Exposure_Environment_Variables.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 526 Information Exposure Through Environment Variables
* Sinks: Servlet
*    GoodSink: no exposing
*    BadSink : expose the path variable to the user
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE526_Info_Exposure_Environment_Variables;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE526_Info_Exposure_Environment_Variables__Servlet_12 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FLAW: environment variable exposed */
            response.getWriter().println("Not in path: " + System.getenv("PATH"));
        }
        else
        {

            /* FIX: error message is general */
            response.getWriter().println("Not in path");

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FIX: error message is general */
            response.getWriter().println("Not in path");
        }
        else
        {

            /* FIX: error message is general */
            response.getWriter().println("Not in path");

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
