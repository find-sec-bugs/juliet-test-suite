/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_File_54d.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-54d.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE601_Open_Redirect__Servlet_File_54d
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE601_Open_Redirect__Servlet_File_54e()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE601_Open_Redirect__Servlet_File_54e()).goodG2BSink(data , request, response);
    }
}
