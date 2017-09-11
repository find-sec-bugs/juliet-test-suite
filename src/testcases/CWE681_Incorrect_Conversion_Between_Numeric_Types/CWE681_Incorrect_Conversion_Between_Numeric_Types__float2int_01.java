/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE681_Incorrect_Conversion_Between_Numeric_Types__float2int_01.java
Label Definition File: CWE681_Incorrect_Conversion_Between_Numeric_Types.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 681 Incorrect Conversion Between Numeric Types
* Sinks: float2int
*    GoodSink: check value before conversion
*    BadSink : conversion may be unsafe
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE681_Incorrect_Conversion_Between_Numeric_Types;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

import java.util.logging.Level;

public class CWE681_Incorrect_Conversion_Between_Numeric_Types__float2int_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;

        try
        {
            /* Enter: 1e20f, result should be 2147483647 (for bad case) */

            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            float num = 0;

            IO.writeString("Enter float number (1e20f): ");

            try
            {
                num = Float.parseFloat(readerBuffered.readLine());
            }
            catch (NumberFormatException exceptionNumberFormat)
            {
                IO.writeLine("Error parsing number");
            }

            /* FLAW: should not cast without checking if conversion is safe */
            IO.writeLine("" + (int)num);
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

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;

        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            float num = 0;

            IO.writeString("Enter float number (1e20f): ");

            try
            {
                num = Float.parseFloat(readerBuffered.readLine());
            }
            catch (NumberFormatException exceptionNumberFormat)
            {
                IO.writeLine("Error parsing number");
            }

            /* FIX: check to make sure conversion is safe */
            if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
            {
                IO.writeLine("Value is too small or large to be represented as an int");
            }
            else
            {
                IO.writeLine("" + (int)num);
            }
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

