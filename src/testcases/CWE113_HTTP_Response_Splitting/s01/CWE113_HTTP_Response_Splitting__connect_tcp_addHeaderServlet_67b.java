/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__connect_tcp_addHeaderServlet_67b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: addHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addHeader()
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__connect_tcp_addHeaderServlet_67b
{
    public void badSink(CWE113_HTTP_Response_Splitting__connect_tcp_addHeaderServlet_67a.Container dataContainer , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataContainer.containerOne;

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE113_HTTP_Response_Splitting__connect_tcp_addHeaderServlet_67a.Container dataContainer , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataContainer.containerOne;

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(CWE113_HTTP_Response_Splitting__connect_tcp_addHeaderServlet_67a.Container dataContainer , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataContainer.containerOne;

        /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
        if (data != null)
        {
            data = URLEncoder.encode(data, "UTF-8");
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }
}
