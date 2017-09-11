/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__console_readLine_write_61a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: console_readLine Read count from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__console_readLine_write_61a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count = (new CWE400_Resource_Exhaustion__console_readLine_write_61b()).badSource();

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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int count = (new CWE400_Resource_Exhaustion__console_readLine_write_61b()).goodG2BSource();

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int count = (new CWE400_Resource_Exhaustion__console_readLine_write_61b()).goodB2GSource();

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
