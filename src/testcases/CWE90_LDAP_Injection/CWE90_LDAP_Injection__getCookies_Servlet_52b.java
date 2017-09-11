/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__getCookies_Servlet_52b.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__getCookies_Servlet_52b
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getCookies_Servlet_52c()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__getCookies_Servlet_52c()).goodG2BSink(data , request, response);
    }
}
