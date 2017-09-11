/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_database_53c.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE601_Open_Redirect__Servlet_database_53c
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE601_Open_Redirect__Servlet_database_53d()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE601_Open_Redirect__Servlet_database_53d()).goodG2BSink(data , request, response);
    }
}
