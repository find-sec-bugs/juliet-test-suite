/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_URLConnection_15.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-15.tmpl.java
*/
/*
* @description
* CWE: 601 Open Redirect
* BadSource: URLConnection Read data from a web server with URLConnection
* GoodSource: A hardcoded string
* BadSink:  place redirect string directly into redirect api call
* Flow Variant: 15 Control flow: switch(6)
*
* */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;

import java.net.URI;
import java.net.URISyntaxException;

public class CWE601_Open_Redirect__Servlet_URLConnection_15 extends AbstractTestCaseServlet
{
    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = null;

        switch (6)
        {
        case 6:
            data = ""; /* Initialize data */
            /* read input from URLConnection */
            {
                URLConnection urlConnection = (new URL("http://www.example.org/")).openConnection();
                BufferedReader readerBuffered = null;
                InputStreamReader readerInputStream = null;
                try
                {
                    readerInputStream = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                    /* This will be reading the first "line" of the response body,
                     * which could be very long if there are no newlines in the HTML */
                    data = readerBuffered.readLine();
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
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
             */
            URI uri;
            try
            {
                uri = new URI(data);
            }
            catch (URISyntaxException exceptURISyntax)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

    /* goodG2B1() - use goodsource and badsink by changing the  switch to switch(5) */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = null;

        switch (5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        default:
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
             */
            URI uri;
            try
            {
                uri = new URI(data);
            }
            catch (URISyntaxException exceptURISyntax)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the switch  */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = null;

        switch (6)
        {
        case 6:
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
             */
            URI uri;
            try
            {
                uri = new URI(data);
            }
            catch (URISyntaxException exceptURISyntax)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
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
