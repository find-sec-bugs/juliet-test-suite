/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE83_XSS_Attribute__Servlet_getParameter_Servlet_17.java
Label Definition File: CWE83_XSS_Attribute__Servlet.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 83 Cross Site Scripting (XSS) in attributes; Examples(replace QUOTE with an actual double quote): ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEalert(1) and ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEjavascript:alert(1)
* BadSource: getParameter_Servlet Read data from a querystring using getParameter()
* GoodSource: A hardcoded string
* BadSink: printlnServlet XSS in img src attribute
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE83_XSS_Attribute;

import testcasesupport.*;

import javax.servlet.http.*;


public class CWE83_XSS_Attribute__Servlet_getParameter_Servlet_17 extends AbstractTestCaseServlet
{
    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        for (int i = 0; i < 1; i++)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: Input is not verified/sanitized before use in an image tag */
                response.getWriter().println("<br>bad() - <img src=\"" + data + "\">");
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
     * for statement with the one in the for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        for (int i = 0; i < 1; i++)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: Input is not verified/sanitized before use in an image tag */
                response.getWriter().println("<br>bad() - <img src=\"" + data + "\">");
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
