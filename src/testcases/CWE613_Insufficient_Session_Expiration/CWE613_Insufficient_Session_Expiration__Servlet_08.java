/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE613_Insufficient_Session_Expiration__Servlet_08.java
Label Definition File: CWE613_Insufficient_Session_Expiration__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 613 Insufficient Session Expiration
* Sinks:
*    GoodSink: force session to expire
*    BadSink : set session to never expire
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */

package testcases.CWE613_Insufficient_Session_Expiration;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE613_Insufficient_Session_Expiration__Servlet_08 extends AbstractTestCaseServlet
{
    /* The methods below always return the same value, so a tool
     * should be able to figure out that every call to these
     * methods will return true or return false.
     */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateReturnsTrue())
        {
            HttpSession sesssion = request.getSession(true);
            /* FLAW: A negative time indicates the session should never expire */
            sesssion.setMaxInactiveInterval(-1);
            response.getWriter().write("bad(): Session still valid");
        }
    }

    /* good1() changes privateReturnsTrue() to privateReturnsFalse() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            HttpSession sesssion = request.getSession(true);

            /* FIX: enforce an absolute session timeout of 30 seconds */
            if (sesssion.getCreationTime() + 30000 > System.currentTimeMillis())
            {
                response.getWriter().write("good(): Invalidating session per absolute timeout enforcement");
                sesssion.invalidate();
                return;
            }
            else
            {
                response.getWriter().write("good(): Session still valid");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateReturnsTrue())
        {
            HttpSession sesssion = request.getSession(true);
            /* FIX: enforce an absolute session timeout of 30 seconds */
            if (sesssion.getCreationTime() + 30000 > System.currentTimeMillis())
            {
                response.getWriter().write("good(): Invalidating session per absolute timeout enforcement");
                sesssion.invalidate();
                return;
            }
            else
            {
                response.getWriter().write("good(): Session still valid");
            }
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
