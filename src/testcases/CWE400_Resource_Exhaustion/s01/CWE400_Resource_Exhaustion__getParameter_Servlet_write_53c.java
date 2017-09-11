/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getParameter_Servlet_write_53c.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: getParameter_Servlet Read count from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE400_Resource_Exhaustion__getParameter_Servlet_write_53c
{
    public void badSink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__getParameter_Servlet_write_53d()).badSink(count , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__getParameter_Servlet_write_53d()).goodG2BSink(count , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__getParameter_Servlet_write_53d()).goodB2GSink(count , request, response);
    }
}
