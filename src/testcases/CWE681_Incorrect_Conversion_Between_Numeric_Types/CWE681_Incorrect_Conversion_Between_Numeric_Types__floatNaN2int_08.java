/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE681_Incorrect_Conversion_Between_Numeric_Types__floatNaN2int_08.java
Label Definition File: CWE681_Incorrect_Conversion_Between_Numeric_Types.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 681 Incorrect Conversion Between Numeric Types
* Sinks: floatNaN2int
*    GoodSink: check for negative sqrt
*    BadSink : sqrt to unchecked value
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */

package testcases.CWE681_Incorrect_Conversion_Between_Numeric_Types;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

import java.util.logging.Level;

public class CWE681_Incorrect_Conversion_Between_Numeric_Types__floatNaN2int_08 extends AbstractTestCase
{
    /* The methods below always return the same value, so a tool
     * should be able to figure out that every call to these
     * methods will return true or return false.
     */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (privateReturnsTrue())
        {
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;
            try
            {
                /*  * Enter: -2.0, result should be 0 (for bad case)
                 *
                 * Square root of a negative number is NaN. NaN when casted to int is 0.
                 */
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
                float num = 0;
                IO.writeString("Enter float number (-2.0): ");
                try
                {
                    num = Float.parseFloat(readerBuffered.readLine());
                }
                catch (NumberFormatException exceptionNumberFormat)
                {
                    IO.writeLine("Error parsing number");
                }
                /* FLAW: should not cast without checking if conversion is safe */
                IO.writeLine("" + (int)(Math.sqrt(num)));
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
    }

    /* good1() changes privateReturnsTrue() to privateReturnsFalse() */
    private void good1() throws Throwable
    {
        if (privateReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;

            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
                IO.writeString("Enter float number: ");
                float num = 0;
                try
                {
                    num = Float.parseFloat(readerBuffered.readLine());
                }
                catch (NumberFormatException exceptionNumberFormat)
                {
                    IO.writeLine("Error parsing number");
                }

                /* FIX: check for sign */
                if (num < 0)
                {
                    IO.writeLine("Negative Number");
                }
                else
                {
                    IO.writeLine("" + (int)(Math.sqrt(num)));
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
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateReturnsTrue())
        {
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;
            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
                IO.writeString("Enter float number: ");
                float num = 0;
                try
                {
                    num = Float.parseFloat(readerBuffered.readLine());
                }
                catch (NumberFormatException exceptionNumberFormat)
                {
                    IO.writeLine("Error parsing number");
                }
                /* FIX: check for sign */
                if (num < 0)
                {
                    IO.writeLine("Negative Number");
                }
                else
                {
                    IO.writeLine("" + (int)(Math.sqrt(num)));
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
