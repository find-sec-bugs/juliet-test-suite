/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_74b.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_74b
{
    public void badSink(HashMap<Integer,String> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataHashMap.get(2);

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

        /* POTENTIAL FLAW: Store data directly in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(HashMap<Integer,String> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataHashMap.get(2);

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

        /* POTENTIAL FLAW: Store data directly in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(HashMap<Integer,String> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataHashMap.get(2);

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
