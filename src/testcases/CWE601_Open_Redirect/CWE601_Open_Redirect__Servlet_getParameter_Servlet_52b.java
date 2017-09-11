/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_getParameter_Servlet_52b.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE601_Open_Redirect__Servlet_getParameter_Servlet_52b
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE601_Open_Redirect__Servlet_getParameter_Servlet_52c()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE601_Open_Redirect__Servlet_getParameter_Servlet_52c()).goodG2BSink(data , request, response);
    }
}
