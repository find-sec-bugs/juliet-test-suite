/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE83_XSS_Attribute__Servlet_File_71b.java
Label Definition File: CWE83_XSS_Attribute__Servlet.label.xml
Template File: sources-sink-71b.tmpl.java
*/
/*
 * @description
 * CWE: 83 Cross Site Scripting (XSS) in attributes; Examples(replace QUOTE with an actual double quote): ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEalert(1) and ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEjavascript:alert(1)
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: printlnServlet
 *    BadSink : XSS in img src attribute
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE83_XSS_Attribute;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE83_XSS_Attribute__Servlet_File_71b
{
    public void badSink(Object dataObject , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (String)dataObject;

        if (data != null)
        {
            /* POTENTIAL FLAW: Input is not verified/sanitized before use in an image tag */
            response.getWriter().println("<br>bad() - <img src=\"" + data + "\">");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Object dataObject , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (String)dataObject;

        if (data != null)
        {
            /* POTENTIAL FLAW: Input is not verified/sanitized before use in an image tag */
            response.getWriter().println("<br>bad() - <img src=\"" + data + "\">");
        }

    }
}
