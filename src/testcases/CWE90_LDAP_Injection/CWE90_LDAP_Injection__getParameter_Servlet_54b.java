/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__getParameter_Servlet_54b.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-54b.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__getParameter_Servlet_54b
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getParameter_Servlet_54c()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getParameter_Servlet_54c()).goodG2BSink(data , request, response);
    }
}
