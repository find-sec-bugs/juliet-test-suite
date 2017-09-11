/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__getCookies_Servlet_81_base.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE90_LDAP_Injection__getCookies_Servlet_81_base
{
    public abstract void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
