/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_68a.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 566 Authorization Bypass through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * BadSink: writeConsole user authorization not checked
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_68a extends AbstractTestCaseServlet
{
    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: Get the user ID from a URL parameter */
        data = request.getParameter("id");

        (new CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_68b()).badSink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: Use a hardcoded user ID */
        data = "10";

        (new CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_68b()).goodG2BSink(request, response);
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
