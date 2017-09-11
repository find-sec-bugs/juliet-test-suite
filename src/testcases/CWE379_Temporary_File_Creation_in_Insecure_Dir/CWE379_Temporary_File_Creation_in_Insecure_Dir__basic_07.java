/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE379_Temporary_File_Creation_in_Insecure_Dir__basic_07.java
Label Definition File: CWE379_Temporary_File_Creation_in_Insecure_Dir__basic.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 379 File Creation in Insecure Directory
* Sinks:
*    GoodSink: Restrict permissions on directory
*    BadSink : Permissions never set on directory
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE379_Temporary_File_Creation_in_Insecure_Dir;

import testcasesupport.*;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE379_Temporary_File_Creation_in_Insecure_Dir__basic_07 extends AbstractTestCase
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad() throws Throwable
    {
        if (privateFive == 5)
        {
            FileOutputStream streamFileOutput = null;
            OutputStreamWriter writerOutputStream = null;
            BufferedWriter writerBuffered = null;
            File tempFile = null;
            String directoryName;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                directoryName = "C:\\testcases\\insecureDir";
            }
            else
            {
                /* running on non-Windows */
                directoryName = "/home/user/testcases/insecureDir/";
            }
            try
            {
                File newDirectory = new File(directoryName);
                /* FLAW: Permissions never set on directory */
                boolean isSuccessful = newDirectory.mkdir();
                if (isSuccessful)
                {
                    IO.writeLine("Directory created");
                    tempFile = File.createTempFile("temp", "1234", newDirectory);
                    /* Set file as writable by owner, readable by owner, not executable (if file system supports it) */
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
                    /* Write something to the file */
                    streamFileOutput = new FileOutputStream(tempFile);
                    writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
                    writerBuffered = new BufferedWriter(writerOutputStream);
                    writerBuffered.write(42);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", exceptIO);
            }
            finally
            {
                /* Delete the temporary file */
                if (tempFile.exists())
                {
                    tempFile.delete();
                }

                try
                {
                    if (writerBuffered != null)
                    {
                        writerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", exceptIO);
                }

                try
                {
                    if (writerOutputStream != null)
                    {
                        writerOutputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", exceptIO);
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
        }
    }

    /* good1() changes privateFive==5 to privateFive!=5 */
    private void good1() throws Throwable
    {
        if (privateFive != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            FileOutputStream streamFileOutput = null;
            OutputStreamWriter writerOutputStream = null;
            BufferedWriter writerBuffered = null;
            File tempFile = null;

            String directoryName;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                directoryName = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\secureDir";
            }
            else
            {
                /* running on non-Windows */
                directoryName = "/home/user/testcases/CWE379_File_Creation_in_Insecure_Dir/secureDir/";
            }

            try
            {
                File newDirectory = new File(directoryName);

                /* FIX: Set newDirectory as writable by owner, readable by owner, not executable (if file system supports it) */
                if (!newDirectory.setWritable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Writable permissions");
                }
                if (!newDirectory.setReadable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Readable permissions");
                }
                if (!newDirectory.setExecutable(false))
                {
                    IO.logger.log(Level.WARNING, "Could not set Executable permissions");
                }

                boolean isSuccessful = newDirectory.mkdir();
                if (isSuccessful)
                {
                    IO.writeLine("Directory created");
                    tempFile = File.createTempFile("temp", "1234", newDirectory);
                    /* Set file as writable by owner, readable by owner, not executable (if file system supports it) */
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
                    /* Write something to the file */
                    streamFileOutput = new FileOutputStream(tempFile);
                    writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
                    writerBuffered = new BufferedWriter(writerOutputStream);
                    writerBuffered.write(42);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", exceptIO);
            }
            finally
            {
                /* Delete the temporary file */
                if (tempFile.exists())
                {
                    tempFile.delete();
                }

                try
                {
                    if (writerBuffered != null)
                    {
                        writerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", exceptIO);
                }

                try
                {
                    if (writerOutputStream != null)
                    {
                        writerOutputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", exceptIO);
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

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateFive == 5)
        {
            FileOutputStream streamFileOutput = null;
            OutputStreamWriter writerOutputStream = null;
            BufferedWriter writerBuffered = null;
            File tempFile = null;
            String directoryName;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                directoryName = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\secureDir";
            }
            else
            {
                /* running on non-Windows */
                directoryName = "/home/user/testcases/CWE379_File_Creation_in_Insecure_Dir/secureDir/";
            }
            try
            {
                File newDirectory = new File(directoryName);
                /* FIX: Set newDirectory as writable by owner, readable by owner, not executable (if file system supports it) */
                if (!newDirectory.setWritable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Writable permissions");
                }
                if (!newDirectory.setReadable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Readable permissions");
                }
                if (!newDirectory.setExecutable(false))
                {
                    IO.logger.log(Level.WARNING, "Could not set Executable permissions");
                }
                boolean isSuccessful = newDirectory.mkdir();
                if (isSuccessful)
                {
                    IO.writeLine("Directory created");
                    tempFile = File.createTempFile("temp", "1234", newDirectory);
                    /* Set file as writable by owner, readable by owner, not executable (if file system supports it) */
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
                    /* Write something to the file */
                    streamFileOutput = new FileOutputStream(tempFile);
                    writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
                    writerBuffered = new BufferedWriter(writerOutputStream);
                    writerBuffered.write(42);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", exceptIO);
            }
            finally
            {
                /* Delete the temporary file */
                if (tempFile.exists())
                {
                    tempFile.delete();
                }

                try
                {
                    if (writerBuffered != null)
                    {
                        writerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", exceptIO);
                }

                try
                {
                    if (writerOutputStream != null)
                    {
                        writerOutputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", exceptIO);
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
