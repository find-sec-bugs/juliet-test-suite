/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE539_Information_Exposure_Through_Persistent_Cookie__Servlet_04.java
Label Definition File: CWE539_Information_Exposure_Through_Persistent_Cookie__Servlet.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 539 Information Exposure Through Persistent Cookie
* Sinks:
*    GoodSink: Do not use a persistent cookie
*    BadSink : Use a persistent cookie
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE) and if(PRIVATE_STATIC_FINAL_FALSE)
*
* */

package testcases.CWE539_Information_Exposure_Through_Persistent_Cookie;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE539_Information_Exposure_Through_Persistent_Cookie__Servlet_04 extends AbstractTestCaseServlet
{
    /* The two variables below are declared "final", so a tool should
     * be able to identify that reads of these will always return their
     * initialized values.
     */
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;
    private static final boolean PRIVATE_STATIC_FINAL_FALSE = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            Cookie cookie = new Cookie("SecretMessage", "test");
            /* FLAW: Make the cookie persistent, by setting the expiration to 5 years */
            cookie.setMaxAge(60*60*24*365*5);
        }
    }

    /* good1() changes PRIVATE_STATIC_FINAL_TRUE to PRIVATE_STATIC_FINAL_FALSE */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            Cookie cookie = new Cookie("SecretMessage", "test");

            /* FIX: Set the max age to a negative value, so that it will only persist until the browser is shutdown */
            cookie.setMaxAge(-1);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            Cookie cookie = new Cookie("SecretMessage", "test");
            /* FIX: Set the max age to a negative value, so that it will only persist until the browser is shutdown */
            cookie.setMaxAge(-1);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
