/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_getCookies_Servlet_67b.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-67b.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URI;
import java.net.URISyntaxException;

public class CWE601_Open_Redirect__Servlet_getCookies_Servlet_67b
{
    public void badSink(CWE601_Open_Redirect__Servlet_getCookies_Servlet_67a.Container dataContainer , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataContainer.containerOne;

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
             */
            URI uri;
            try
            {
                uri = new URI(data);
            }
            catch (URISyntaxException exceptURISyntax)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE601_Open_Redirect__Servlet_getCookies_Servlet_67a.Container dataContainer , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataContainer.containerOne;

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
             */
            URI uri;
            try
            {
                uri = new URI(data);
            }
            catch (URISyntaxException exceptURISyntax)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }
}
