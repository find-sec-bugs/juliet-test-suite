/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__random_write_75b.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-75b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;


public class CWE400_Resource_Exhaustion__random_write_75b
{
    public void badSink(byte[] countSerialized ) throws Throwable
    {
        /* unserialize count */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;

        try
        {
            streamByteArrayInput = new ByteArrayInputStream(countSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            int count = (Integer)streamObjectInput.readObject();

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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(byte[] countSerialized ) throws Throwable
    {
        /* unserialize count */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;

        try {
            streamByteArrayInput = new ByteArrayInputStream(countSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            int count = (Integer)streamObjectInput.readObject();

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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(byte[] countSerialized ) throws Throwable
    {
        /* unserialize count */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;

        try
        {
            streamByteArrayInput = new ByteArrayInputStream(countSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            int count = (Integer)streamObjectInput.readObject();

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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }
}
