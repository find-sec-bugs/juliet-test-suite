/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__Property_54d.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: Property Read data from a system property
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

public class CWE643_Xpath_Injection__Property_54d
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE643_Xpath_Injection__Property_54e()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE643_Xpath_Injection__Property_54e()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE643_Xpath_Injection__Property_54e()).goodB2GSink(data );
    }
}
