/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__File_addHeaderServlet_66b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: addHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addHeader()
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__File_addHeaderServlet_66b
{
    public void badSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
        if (data != null)
        {
            data = URLEncoder.encode(data, "UTF-8");
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }
}
