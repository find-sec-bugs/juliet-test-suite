/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE526_Info_Exposure_Environment_Variables__Servlet_01.java
Label Definition File: CWE526_Info_Exposure_Environment_Variables.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 526 Information Exposure Through Environment Variables
* Sinks: Servlet
*    GoodSink: no exposing
*    BadSink : expose the path variable to the user
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE526_Info_Exposure_Environment_Variables;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE526_Info_Exposure_Environment_Variables__Servlet_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: environment variable exposed */
        response.getWriter().println("Not in path: " + System.getenv("PATH"));

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: error message is general */
        response.getWriter().println("Not in path");

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

