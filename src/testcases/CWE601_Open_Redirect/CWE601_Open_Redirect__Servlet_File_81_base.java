/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_File_81_base.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE601_Open_Redirect__Servlet_File_81_base
{
    public abstract void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
