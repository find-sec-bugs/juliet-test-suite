/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_kerberosKey_21.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: URLConnection Read password from a web server with URLConnection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: kerberosKey
 *    GoodSink: Decrypt password before using in KerberosKey()
 *    BadSink : Use password directly in KerberosKey()
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;

import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_kerberosKey_21 extends AbstractTestCase
{
    /* The variable below is used to drive control flow in the sink function */
    private boolean badPrivate = false;

    public void bad() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* read input from URLConnection */
        {
            URLConnection urlConnection = (new URL("http://www.example.org/")).openConnection();
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;

            try
            {
                readerInputStream = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read password from a web server with URLConnection */
                /* This will be reading the first "line" of the response body,
                 * which could be very long if there are no newlines in the HTML */
                password = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* clean up stream reading objects */
                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }
            }
        }

        badPrivate = true;
        badSink(password );
    }

    private void badSink(String password ) throws Throwable
    {
        if (badPrivate)
        {
            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* POTENTIAL FLAW: Use password directly in KerberosKey() */
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }
        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1Private = false;
    private boolean goodB2G2Private = false;
    private boolean goodG2BPrivate = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* read input from URLConnection */
        {
            URLConnection urlConnection = (new URL("http://www.example.org/")).openConnection();
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;

            try
            {
                readerInputStream = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read password from a web server with URLConnection */
                /* This will be reading the first "line" of the response body,
                 * which could be very long if there are no newlines in the HTML */
                password = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* clean up stream reading objects */
                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }
            }
        }

        goodB2G1Private = false;
        goodB2G1Sink(password );
    }

    private void goodB2G1Sink(String password ) throws Throwable
    {
        if (goodB2G1Private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aesCipher = Cipher.getInstance("AES");
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                    password = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* read input from URLConnection */
        {
            URLConnection urlConnection = (new URL("http://www.example.org/")).openConnection();
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;

            try
            {
                readerInputStream = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read password from a web server with URLConnection */
                /* This will be reading the first "line" of the response body,
                 * which could be very long if there are no newlines in the HTML */
                password = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* clean up stream reading objects */
                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }
            }
        }

        goodB2G2Private = true;
        goodB2G2Sink(password );
    }

    private void goodB2G2Sink(String password ) throws Throwable
    {
        if (goodB2G2Private)
        {
            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aesCipher = Cipher.getInstance("AES");
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                    password = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }
        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String password;

        /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
        /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
        password = "Password1234!";

        goodG2BPrivate = true;
        goodG2BSink(password );
    }

    private void goodG2BSink(String password ) throws Throwable
    {
        if (goodG2BPrivate)
        {
            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* POTENTIAL FLAW: Use password directly in KerberosKey() */
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }
        }
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
