/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_66b.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import javax.servlet.http.*;

import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_66b
{
    public void badSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

        /* POTENTIAL FLAW: Store data directly in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

        /* POTENTIAL FLAW: Store data directly in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String dataArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataArray[2];

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
