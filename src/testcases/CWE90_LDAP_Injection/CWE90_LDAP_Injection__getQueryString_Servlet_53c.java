/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__getQueryString_Servlet_53c.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__getQueryString_Servlet_53c
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getQueryString_Servlet_53d()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getQueryString_Servlet_53d()).goodG2BSink(data , request, response);
    }
}
