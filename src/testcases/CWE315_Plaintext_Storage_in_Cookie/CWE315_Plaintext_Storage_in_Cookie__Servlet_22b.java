/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_22b.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import javax.servlet.http.*;

import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_22b
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE315_Plaintext_Storage_in_Cookie__Servlet_22a.badPublicStatic)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1Sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE315_Plaintext_Storage_in_Cookie__Servlet_22a.goodB2G1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Hash data before storing in cookie */
            {
                String salt = "ThisIsMySalt";
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.reset();
                byte[] hashedCredsAsBytes = messageDigest.digest((salt+data).getBytes("UTF-8"));
                data = IO.toHex(hashedCredsAsBytes);
            }

            response.addCookie(new Cookie("auth", data));

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2Sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE315_Plaintext_Storage_in_Cookie__Servlet_22a.goodB2G2PublicStatic)
        {
            /* FIX: Hash data before storing in cookie */
            {
                String salt = "ThisIsMySalt";
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.reset();
                byte[] hashedCredsAsBytes = messageDigest.digest((salt+data).getBytes("UTF-8"));
                data = IO.toHex(hashedCredsAsBytes);
            }
            response.addCookie(new Cookie("auth", data));
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (CWE315_Plaintext_Storage_in_Cookie__Servlet_22a.goodG2BPublicStatic)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }
}
