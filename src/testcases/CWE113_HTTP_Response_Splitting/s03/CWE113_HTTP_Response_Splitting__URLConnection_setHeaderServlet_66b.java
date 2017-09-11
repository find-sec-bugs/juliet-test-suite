/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_66b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: setHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to setHeader()
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s03;
import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_66b
{
    public void badSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        if (data != null)
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in header */
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        if (data != null)
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in header */
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        if (data != null)
        {
            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            data = URLEncoder.encode(data, "UTF-8");
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }

    }
}
