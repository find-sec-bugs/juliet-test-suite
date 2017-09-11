/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE81_XSS_Error_Message__Servlet_getQueryString_Servlet_72b.java
Label Definition File: CWE81_XSS_Error_Message__Servlet.label.xml
Template File: sources-sink-72b.tmpl.java
*/
/*
 * @description
 * CWE: 81 Cross Site Scripting (XSS) in Error Message
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: sendErrorServlet
 *    BadSink : XSS in sendError
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE81_XSS_Error_Message;

import testcasesupport.*;
import java.util.Vector;

import javax.servlet.http.*;

public class CWE81_XSS_Error_Message__Servlet_getQueryString_Servlet_72b
{
    public void badSink(Vector<String> dataVector , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataVector.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client;
            * The built-in J2EE server automatically does some HTML entity encoding.
            * Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
            */
            response.sendError(404, "<br>bad() - Parameter name has value " + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Vector<String> dataVector , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataVector.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client;
            * The built-in J2EE server automatically does some HTML entity encoding.
            * Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
            */
            response.sendError(404, "<br>bad() - Parameter name has value " + data);
        }

    }
}
