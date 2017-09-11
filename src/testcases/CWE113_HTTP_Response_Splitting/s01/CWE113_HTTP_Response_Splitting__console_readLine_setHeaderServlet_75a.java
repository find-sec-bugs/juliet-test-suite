/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__console_readLine_setHeaderServlet_75a.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-75a.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: console_readLine Read data from the console using readLine()
 * GoodSource: A hardcoded string
 * Sinks: setHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to setHeader()
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CWE113_HTTP_Response_Splitting__console_readLine_setHeaderServlet_75a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        {
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;

            /* read user input from console with readLine */
            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read data from the console using readLine */
                data = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
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
        /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            (new CWE113_HTTP_Response_Splitting__console_readLine_setHeaderServlet_75b()).badSink(dataSerialized , request, response );
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            (new CWE113_HTTP_Response_Splitting__console_readLine_setHeaderServlet_75b()).goodG2BSink(dataSerialized , request, response );
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
            }
        }
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        {
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;

            /* read user input from console with readLine */
            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read data from the console using readLine */
                data = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
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
        /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            (new CWE113_HTTP_Response_Splitting__console_readLine_setHeaderServlet_75b()).goodB2GSink(dataSerialized , request, response );
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
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
