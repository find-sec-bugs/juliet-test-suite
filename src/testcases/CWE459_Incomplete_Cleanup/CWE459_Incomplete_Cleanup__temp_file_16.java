/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE459_Incomplete_Cleanup__temp_file_16.java
Label Definition File: CWE459_Incomplete_Cleanup.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 459 Incomplete Cleanup
* Sinks: temp_file
*    GoodSink: Delete the temporary file on exit
*    BadSink : Don't delete the temporary file
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE459_Incomplete_Cleanup;

import testcasesupport.*;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE459_Incomplete_Cleanup__temp_file_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            File tempFile = null;
            try
            {
                tempFile = File.createTempFile("temp", "1234");
                IO.writeLine(tempFile.toString());
                /* FLAW: Do not delete the temporary file */
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
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            File tempFile = null;
            try
            {
                tempFile = File.createTempFile("temp", "1234");
                IO.writeLine(tempFile.toString());
                /* FIX: Call deleteOnExit() so that the file will be deleted */
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
            break;
        }
    }

    public void good() throws Throwable
    {
        good1();
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
