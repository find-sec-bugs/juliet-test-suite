/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Servlet_03.java
Label Definition File: CWE400_Resource_Exhaustion__Servlet.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* Sinks:
*    GoodSink: Size of uploaded file restricted to 10 MB
*    BadSink : No restriction on upload size
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__Servlet_03 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (5 == 5)
        {
            /**
             * Inspiration from:
             * http://forums.codecharge.com/posts.php?post_id=44078
             * and
             * http://commons.apache.org/downloads/download_fileupload.cgi
             * class FileUploadBase, method parseRequest()
             * class Streams, method copy()
             *
             * We don't actually parse out the filename or any of the other data since it really
             * doesn't matter for this test. (We don't care if part of the HTTP request ends up in
             * the file.
             *
             * Note that if you try to run this file, you'll always get an exception from the bad method.
             * This is because you've already read the full httprequest stream and stored it into a file.
             * So, expect the bad method to always fail if you directly run this file from eclipse.
             */
            if (request.getContentType() == null || !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }
            FileOutputStream streamFileOutput = null;
            InputStream streamInput = null;
            try
            {
                streamFileOutput = new FileOutputStream("output_bad.dat");
                streamInput = request.getInputStream();
                for (;;)
                {
                    byte[] inputBytes = new byte[1024];
                    int bytesRead = streamInput.read(inputBytes); /* FLAW: no restriction on file size */
                    if (bytesRead == -1)
                    {
                        break;
                    }
                    streamFileOutput.write(inputBytes);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error!", exceptIO);
            }
            finally
            {
                try
                {
                    if (streamInput != null)
                    {
                        streamInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStream", exceptIO);
                }

                try
                {
                    if (streamFileOutput != null)
                    {
                        streamFileOutput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
                }
            }
            response.getWriter().write("Uploaded file!");
        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (5 != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            if (request.getContentType() == null || !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }

            FileOutputStream streamFileOutput = null;
            InputStream streamInput = null;

            try
            {
                streamFileOutput = new FileOutputStream("output_good.dat");
                streamInput = request.getInputStream();

                /* set max filesize to 10 MB */
                final int MAXSIZE = 10485760;
                int bytesReadCount = 0;
                for (;;)
                {
                    /* FIX: max file size check */
                    if (bytesReadCount >= MAXSIZE)
                    {
                        response.getWriter().write("File exceeds MAXSIZE!");
                        break;
                    }
                    byte[] inputBytes = new byte[1024];
                    int bytesRead = streamInput.read(inputBytes);
                    if (bytesRead == -1)
                    {
                        break;
                    }
                    bytesReadCount += bytesRead;
                    streamFileOutput.write(inputBytes);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error!", exceptIO);
            }
            finally
            {
                try
                {
                    if (streamInput != null)
                    {
                        streamInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStream", exceptIO);
                }

                try
                {
                    if (streamFileOutput != null)
                    {
                        streamFileOutput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
                }
            }

            response.getWriter().write("Uploaded file!");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (5 == 5)
        {
            if (request.getContentType() == null || !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }
            FileOutputStream streamFileOutput = null;
            InputStream streamInput = null;
            try
            {
                streamFileOutput = new FileOutputStream("output_good.dat");
                streamInput = request.getInputStream();
                /* set max filesize to 10 MB */
                final int MAXSIZE = 10485760;
                int bytesReadCount = 0;
                for (;;)
                {
                    /* FIX: max file size check */
                    if (bytesReadCount >= MAXSIZE)
                    {
                        response.getWriter().write("File exceeds MAXSIZE!");
                        break;
                    }
                    byte[] inputBytes = new byte[1024];
                    int bytesRead = streamInput.read(inputBytes);
                    if (bytesRead == -1)
                    {
                        break;
                    }
                    bytesReadCount += bytesRead;
                    streamFileOutput.write(inputBytes);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error!", exceptIO);
            }
            finally
            {
                try
                {
                    if (streamInput != null)
                    {
                        streamInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStream", exceptIO);
                }

                try
                {
                    if (streamFileOutput != null)
                    {
                        streamFileOutput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
                }
            }
            response.getWriter().write("Uploaded file!");
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
