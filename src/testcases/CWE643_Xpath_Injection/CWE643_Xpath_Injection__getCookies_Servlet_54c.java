/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__getCookies_Servlet_54c.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE643_Xpath_Injection__getCookies_Servlet_54c
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE643_Xpath_Injection__getCookies_Servlet_54d()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE643_Xpath_Injection__getCookies_Servlet_54d()).goodG2BSink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE643_Xpath_Injection__getCookies_Servlet_54d()).goodB2GSink(data , request, response);
    }
}
