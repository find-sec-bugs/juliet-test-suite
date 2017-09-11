/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getQueryString_Servlet_addHeaderServlet_73b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: addHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addHeader()
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getQueryString_Servlet_addHeaderServlet_73b
{
    public void badSink(LinkedList<String> dataLinkedList , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<String> dataLinkedList , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<String> dataLinkedList , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataLinkedList.remove(2);

        /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
        if (data != null)
        {
            data = URLEncoder.encode(data, "UTF-8");
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }
}
