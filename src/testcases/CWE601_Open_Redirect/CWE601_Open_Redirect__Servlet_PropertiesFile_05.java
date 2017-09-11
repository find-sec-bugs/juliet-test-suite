/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_PropertiesFile_05.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-05.tmpl.java
*/
/*
* @description
* CWE: 601 Open Redirect
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: A hardcoded string
* BadSink:  place redirect string directly into redirect api call
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;

import java.net.URI;
import java.net.URISyntaxException;

public class CWE601_Open_Redirect__Servlet_PropertiesFile_05 extends AbstractTestCaseServlet
{
    /* The two variables below are not defined as "final", but are never
     * assigned any other value, so a tool should be able to identify that
     * reads of these will always return their initialized values.
     */
    private boolean privateTrue = true;
    private boolean privateFalse = false;

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateTrue)
        {
            data = ""; /* Initialize data */
            /* retrieve the property */
            {
                Properties properties = new Properties();
                FileInputStream streamFileInput = null;
                try
                {
                    streamFileInput = new FileInputStream("../common/config.properties");
                    properties.load(streamFileInput);
                    /* POTENTIAL FLAW: Read data from a .properties file */
                    data = properties.getProperty("data");
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Close stream reading object */
                    try
                    {
                        if (streamFileInput != null)
                        {
                            streamFileInput.close();
                        }
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                    }
                }
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
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

    /* goodG2B1() - use goodsource and badsink by changing privateTrue to privateFalse */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateFalse)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateTrue)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
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
