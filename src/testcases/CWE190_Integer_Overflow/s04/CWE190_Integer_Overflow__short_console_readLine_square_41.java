/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_console_readLine_square_41.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow.s04;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE190_Integer_Overflow__short_console_readLine_square_41 extends AbstractTestCase
{
    private void badSink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if (data*data) > Short.MAX_VALUE, this will overflow */
        short result = (short)(data * data);

        IO.writeLine("result: " + result);

    }

    public void bad() throws Throwable
    {
        short data;

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
                data = Short.parseShort(stringNumber.trim());
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

        badSink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if (data*data) > Short.MAX_VALUE, this will overflow */
        short result = (short)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        short data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2BSink(data  );
    }

    private void goodB2GSink(short data ) throws Throwable
    {

        /* FIX: Add a check to prevent an overflow from occurring */
        /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
        if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Short.MAX_VALUE)))
        {
            short result = (short)(data * data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform squaring.");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        short data;

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
                data = Short.parseShort(stringNumber.trim());
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

        goodB2GSink(data  );
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
