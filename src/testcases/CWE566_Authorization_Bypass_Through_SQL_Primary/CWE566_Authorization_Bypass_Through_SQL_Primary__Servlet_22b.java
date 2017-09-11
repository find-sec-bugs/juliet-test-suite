/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22b.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 566 Authorization Bypass through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    BadSink : user authorization not checked
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22b
{
    public String badSource(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22a.badPublicStatic)
        {
            /* FLAW: Get the user ID from a URL parameter */
            data = request.getParameter("id");
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1Source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22a.goodG2B1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a hardcoded user ID */
            data = "10";

        }

        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public String goodG2B2Source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22a.goodG2B2PublicStatic)
        {
            /* FIX: Use a hardcoded user ID */
            data = "10";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        return data;
    }
}
