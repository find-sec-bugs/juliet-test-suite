/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_add_42.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE190_Integer_Overflow__byte_console_readLine_add_42 extends AbstractTestCase
{
    private byte badSource() throws Throwable
    {
        byte data;

        /* init data */
        data = -1;

        /* POTENTIAL FLAW: Read data from console with readLine*/
        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;
        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            String stringNumber = readerBuffered.readLine();
            if (stringNumber != null)
            {
                data = Byte.parseByte(stringNumber.trim());
            }
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        catch (NumberFormatException exceptNumberFormat)
        {
            IO.logger.log(Level.WARNING, "Error with number parsing", exceptNumberFormat);
        }
        finally
        {
            /* clean up stream reading objects */
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
            finally
            {
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

        return data;
    }

    public void bad() throws Throwable
    {
        byte data = badSource();

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private byte goodG2BSource() throws Throwable
    {
        byte data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    private void goodG2B() throws Throwable
    {
        byte data = goodG2BSource();

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    private byte goodB2GSource() throws Throwable
    {
        byte data;

        /* init data */
        data = -1;

        /* POTENTIAL FLAW: Read data from console with readLine*/
        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;
        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            String stringNumber = readerBuffered.readLine();
            if (stringNumber != null)
            {
                data = Byte.parseByte(stringNumber.trim());
            }
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        catch (NumberFormatException exceptNumberFormat)
        {
            IO.logger.log(Level.WARNING, "Error with number parsing", exceptNumberFormat);
        }
        finally
        {
            /* clean up stream reading objects */
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
            finally
            {
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

        return data;
    }

    private void goodB2G() throws Throwable
    {
        byte data = goodB2GSource();

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Byte.MAX_VALUE)
        {
            byte result = (byte)(data + 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform addition.");
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
