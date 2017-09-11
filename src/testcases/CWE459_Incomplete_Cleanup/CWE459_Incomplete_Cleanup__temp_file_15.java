/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE459_Incomplete_Cleanup__temp_file_15.java
Label Definition File: CWE459_Incomplete_Cleanup.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 459 Incomplete Cleanup
* Sinks: temp_file
*    GoodSink: Delete the temporary file on exit
*    BadSink : Don't delete the temporary file
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE459_Incomplete_Cleanup;

import testcasesupport.*;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE459_Incomplete_Cleanup__temp_file_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        switch (7)
        {
        case 7:
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
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch (8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        default:
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

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch (7)
        {
        case 7:
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
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
