/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__File_write_31.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: File Read count from file (named c:\data.txt)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;


public class CWE400_Resource_Exhaustion__File_write_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int countCopy;
        {
            int count;

            count = Integer.MIN_VALUE; /* Initialize count */

            {
                File file = new File("C:\\data.txt");
                FileInputStream streamFileInput = null;
                InputStreamReader readerInputStream = null;
                BufferedReader readerBuffered = null;

                try
                {
                    /* read string from file into count */
                    streamFileInput = new FileInputStream(file);
                    readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);

                    /* POTENTIAL FLAW: Read count from a file */
                    /* This will be reading the first "line" of the file, which
                     * could be very long if there are little or no newlines in the file */
                    String stringNumber = readerBuffered.readLine();
                    if (stringNumber != null) /* avoid NPD incidental warnings */
                    {
                        try
                        {
                            count = Integer.parseInt(stringNumber.trim());
                        }
                        catch(NumberFormatException exceptNumberFormat)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing count from string", exceptNumberFormat);
                        }
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Close stream reading objects */
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

            countCopy = count;
        }
        {
            int count = countCopy;

            File file = new File("badSink.txt");
            FileOutputStream streamFileOutput = new FileOutputStream(file);
            OutputStreamWriter writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
            BufferedWriter writerBuffered = new BufferedWriter(writerOutputStream);
            int i;

            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    writerBuffered.write("Hello");
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", exceptIO);
                }
            }

            /* Close stream reading objects */
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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int countCopy;
        {
            int count;

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

            countCopy = count;
        }
        {
            int count = countCopy;

            File file = new File("badSink.txt");
            FileOutputStream streamFileOutput = new FileOutputStream(file);
            OutputStreamWriter writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
            BufferedWriter writerBuffered = new BufferedWriter(writerOutputStream);
            int i;

            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    writerBuffered.write("Hello");
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", exceptIO);
                }
            }

            /* Close stream reading objects */
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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int countCopy;
        {
            int count;

            count = Integer.MIN_VALUE; /* Initialize count */

            {
                File file = new File("C:\\data.txt");
                FileInputStream streamFileInput = null;
                InputStreamReader readerInputStream = null;
                BufferedReader readerBuffered = null;

                try
                {
                    /* read string from file into count */
                    streamFileInput = new FileInputStream(file);
                    readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);

                    /* POTENTIAL FLAW: Read count from a file */
                    /* This will be reading the first "line" of the file, which
                     * could be very long if there are little or no newlines in the file */
                    String stringNumber = readerBuffered.readLine();
                    if (stringNumber != null) /* avoid NPD incidental warnings */
                    {
                        try
                        {
                            count = Integer.parseInt(stringNumber.trim());
                        }
                        catch(NumberFormatException exceptNumberFormat)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing count from string", exceptNumberFormat);
                        }
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Close stream reading objects */
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

            countCopy = count;
        }
        {
            int count = countCopy;

            /* FIX: Validate count before using it as the for loop variant to write to a file */
            if (count > 0 && count <= 20)
            {
                File file = new File("goodSink.txt");
                FileOutputStream streamFileOutput = new FileOutputStream(file);
                OutputStreamWriter writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
                BufferedWriter writerBuffered = new BufferedWriter(writerOutputStream);
                int i;
                for (i = 0; i < count; i++)
                {
                    try
                    {
                        writerBuffered.write("Hello");
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream writing", exceptIO);
                    }
                }
                /* Close stream reading objects */
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
