/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Property_53b.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-53b.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__Property_53b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE90_LDAP_Injection__Property_53c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE90_LDAP_Injection__Property_53c()).goodG2BSink(data );
    }
}
