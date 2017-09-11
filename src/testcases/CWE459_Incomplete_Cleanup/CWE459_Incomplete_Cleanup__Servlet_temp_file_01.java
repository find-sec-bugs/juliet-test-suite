/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE459_Incomplete_Cleanup__Servlet_temp_file_01.java
Label Definition File: CWE459_Incomplete_Cleanup.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 459 Incomplete Cleanup
* Sinks: Servlet_temp_file
*    GoodSink: Delete the temporary file manually
*    BadSink : Use .deleteOnExit() to delete the temp file, potentially leaving the file in existence for a long time
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE459_Incomplete_Cleanup;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE459_Incomplete_Cleanup__Servlet_temp_file_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        File tempFile = null;

        try
        {
            tempFile = File.createTempFile("temp", "1234");

            /* FLAW: Delete the temp file by using .deleteOnExit(). Using this method to delete
             * the file for a Servlet can keep the file in existence for a long time as it will not
             * be deleted until the JVM is shut down. */
            tempFile.deleteOnExit();

            /* Set the permissions to avoid insecure temporary file incidentals  */
            if (!tempFile.setWritable(true, true))
            {
                IO.logger.log(Level.WARNING, "Could not set Writable permissions");
            }
            if (!tempFile.setReadable(true, true))
            {
                IO.logger.log(Level.WARNING, "Could not set Readable permissions");
            }
            if (!tempFile.setExecutable(false))
            {
                IO.logger.log(Level.WARNING, "Could not set Executable permissions");
            }
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Could not create temporary file", exceptIO);
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        File tempFile = null;

        try
        {
            tempFile = File.createTempFile("temp", "1234");

            /* Set the permissions to avoid insecure temporary file incidentals  */
            if (!tempFile.setWritable(true, true))
            {
                IO.logger.log(Level.WARNING, "Could not set Writable permissions");
            }
            if (!tempFile.setReadable(true, true))
            {
                IO.logger.log(Level.WARNING, "Could not set Readable permissions");
            }
            if (!tempFile.setExecutable(false))
            {
                IO.logger.log(Level.WARNING, "Could not set Executable permissions");
            }
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Could not create temporary file", exceptIO);
        }
        finally
        {
            /* FIX: Delete the temporary file manually */
            if (tempFile.exists())
            {
                tempFile.delete();
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

