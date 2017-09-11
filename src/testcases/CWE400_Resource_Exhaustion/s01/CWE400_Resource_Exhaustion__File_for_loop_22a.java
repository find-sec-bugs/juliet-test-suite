/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__File_for_loop_22a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-22a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: File Read count from file (named c:\data.txt)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
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

public class CWE400_Resource_Exhaustion__File_for_loop_22a extends AbstractTestCase
{
    /* The public static variable below is used to drive control flow in the sink function.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean badPublicStatic = false;

    public void bad() throws Throwable
    {
        int count = 0;

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

        badPublicStatic = true;
        (new CWE400_Resource_Exhaustion__File_for_loop_22b()).badSink(count );
    }

    /* The public static variables below are used to drive control flow in the sink functions.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodB2G1PublicStatic = false;
    public static boolean goodB2G2PublicStatic = false;
    public static boolean goodG2BPublicStatic = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        int count = 0;

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

        goodB2G1PublicStatic = false;
        (new CWE400_Resource_Exhaustion__File_for_loop_22b()).goodB2G1Sink(count );
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        int count = 0;

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

        goodB2G2PublicStatic = true;
        (new CWE400_Resource_Exhaustion__File_for_loop_22b()).goodB2G2Sink(count );
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int count = 0;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        goodG2BPublicStatic = true;
        (new CWE400_Resource_Exhaustion__File_for_loop_22b()).goodG2BSink(count );
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
