/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__Property_setHeaderServlet_68b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: setHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to setHeader()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s03;
import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__Property_setHeaderServlet_68b
{
    public void badSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE113_HTTP_Response_Splitting__Property_setHeaderServlet_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in header */
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE113_HTTP_Response_Splitting__Property_setHeaderServlet_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in header */
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE113_HTTP_Response_Splitting__Property_setHeaderServlet_68a.data;

        if (data != null)
        {
            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            data = URLEncoder.encode(data, "UTF-8");
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }

    }
}
