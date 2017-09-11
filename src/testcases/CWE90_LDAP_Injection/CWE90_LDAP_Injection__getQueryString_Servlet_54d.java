/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__getQueryString_Servlet_54d.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-54d.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__getQueryString_Servlet_54d
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getQueryString_Servlet_54e()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getQueryString_Servlet_54e()).goodG2BSink(data , request, response);
    }
}
