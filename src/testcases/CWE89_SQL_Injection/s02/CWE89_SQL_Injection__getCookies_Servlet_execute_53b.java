/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookies_Servlet_execute_53b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: execute
 *    GoodSink: Use prepared statement and execute (properly)
 *    BadSink : data concatenated into SQL statement used in execute(), which could result in SQL Injection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE89_SQL_Injection__getCookies_Servlet_execute_53b
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE89_SQL_Injection__getCookies_Servlet_execute_53c()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE89_SQL_Injection__getCookies_Servlet_execute_53c()).goodG2BSink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE89_SQL_Injection__getCookies_Servlet_execute_53c()).goodB2GSink(data , request, response);
    }
}
