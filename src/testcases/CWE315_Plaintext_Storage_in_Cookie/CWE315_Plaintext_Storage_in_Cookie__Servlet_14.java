/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_14.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-14.tmpl.java
*/
/*
* @description
* CWE: 315 Storing plaintext data in a cookie
* BadSource:  Set data to credentials (without hashing or encryption)
* GoodSource: Set data to a hash of credentials
* Sinks:
*    GoodSink: Hash data before storing in cookie
*    BadSink : Store data directly in cookie
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import javax.servlet.http.*;

import java.security.MessageDigest;

import java.net.PasswordAuthentication;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_14 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = credentials.getUserName() + ":" + (new String(credentials.getPassword()));
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.staticFive==5 to IO.staticFive!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "GP@ssw0rd".toCharArray());

            /* FIX: Set data to a hash of credentials */
            {
                String salt = "ThisIsMySalt";
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.reset();
                String credentialsToHash = credentials.getUserName() + ":" + (new String(credentials.getPassword()));
                byte[] hashedCredsAsBytes = messageDigest.digest((salt+credentialsToHash).getBytes("UTF-8"));
                data = IO.toHex(hashedCredsAsBytes);
            }

        }

        if (IO.staticFive==5)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "GP@ssw0rd".toCharArray());
            /* FIX: Set data to a hash of credentials */
            {
                String salt = "ThisIsMySalt";
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.reset();
                String credentialsToHash = credentials.getUserName() + ":" + (new String(credentials.getPassword()));
                byte[] hashedCredsAsBytes = messageDigest.digest((salt+credentialsToHash).getBytes("UTF-8"));
                data = IO.toHex(hashedCredsAsBytes);
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.staticFive==5 to IO.staticFive!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = credentials.getUserName() + ":" + (new String(credentials.getPassword()));
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = credentials.getUserName() + ":" + (new String(credentials.getPassword()));
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
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

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
