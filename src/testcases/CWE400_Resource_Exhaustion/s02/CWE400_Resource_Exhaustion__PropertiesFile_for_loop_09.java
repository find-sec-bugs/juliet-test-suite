/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__PropertiesFile_for_loop_09.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-09.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: PropertiesFile Read count from a .properties file (in property named data)
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: for_loop
*    GoodSink: Validate count before using it as the loop variant in a for loop
*    BadSink : Use count as the loop variant in a for loop
* Flow Variant: 09 Control flow: if(IO.STATIC_FINAL_TRUE) and if(IO.STATIC_FINAL_FALSE)
*
* */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__PropertiesFile_for_loop_09 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_TRUE)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* retrieve the property */
            {
                Properties properties = new Properties();
                FileInputStream streamFileInput = null;
                try
                {
                    streamFileInput = new FileInputStream("../common/config.properties");
                    properties.load(streamFileInput);
                    /* POTENTIAL FLAW: Read count from a .properties file */
                    String stringNumber = properties.getProperty("data");
                    if (stringNumber != null) // avoid NPD incidental warnings
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
                    /* Close stream reading object */
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
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (IO.STATIC_FINAL_TRUE)
        {
            int i = 0;
            /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.STATIC_FINAL_TRUE to IO.STATIC_FINAL_FALSE */
    private void goodG2B1() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }

        if (IO.STATIC_FINAL_TRUE)
        {
            int i = 0;
            /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_TRUE)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (IO.STATIC_FINAL_TRUE)
        {
            int i = 0;
            /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.STATIC_FINAL_TRUE to IO.STATIC_FINAL_FALSE */
    private void goodB2G1() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_TRUE)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* retrieve the property */
            {
                Properties properties = new Properties();
                FileInputStream streamFileInput = null;
                try
                {
                    streamFileInput = new FileInputStream("../common/config.properties");
                    properties.load(streamFileInput);
                    /* POTENTIAL FLAW: Read count from a .properties file */
                    String stringNumber = properties.getProperty("data");
                    if (stringNumber != null) // avoid NPD incidental warnings
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
                    /* Close stream reading object */
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
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (IO.STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            int i = 0;

            /* FIX: Validate count before using it as the for loop variant */
            if (count > 0 && count <= 20)
            {
                for (i = 0; i < count; i++)
                {
                    IO.writeLine("Hello");
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_TRUE)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* retrieve the property */
            {
                Properties properties = new Properties();
                FileInputStream streamFileInput = null;
                try
                {
                    streamFileInput = new FileInputStream("../common/config.properties");
                    properties.load(streamFileInput);
                    /* POTENTIAL FLAW: Read count from a .properties file */
                    String stringNumber = properties.getProperty("data");
                    if (stringNumber != null) // avoid NPD incidental warnings
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
                    /* Close stream reading object */
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
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (IO.STATIC_FINAL_TRUE)
        {
            int i = 0;
            /* FIX: Validate count before using it as the for loop variant */
            if (count > 0 && count <= 20)
            {
                for (i = 0; i < count; i++)
                {
                    IO.writeLine("Hello");
                }
            }
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
