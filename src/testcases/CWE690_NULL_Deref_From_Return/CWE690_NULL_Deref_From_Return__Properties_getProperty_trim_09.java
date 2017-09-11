/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_09.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-09.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource: Properties_getProperty Set data to return of Properties.getProperty
* GoodSource: Set data to fixed, non-null String
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 09 Control flow: if(IO.STATIC_FINAL_TRUE) and if(IO.STATIC_FINAL_FALSE)
*
* */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.util.logging.Level;

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_09 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
        {
            FileInputStream streamFileInput = null;
            String propertiesFileName = "./CWE690_NULL_Deref_From_Return__Helper.properties";
            try
            {
                streamFileInput = new FileInputStream(propertiesFileName);
                Properties properties = new Properties();
                properties.load(streamFileInput);
                /* POTENTIAL FLAW: data may be set to null */
                data = properties.getProperty("CWE690");
            }
            catch (IOException exceptIO)
            {
                IO.writeLine("Could not open properties file: " + propertiesFileName);
                data = ""; /* ensure that data is initialized */
            }
            finally
            {
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException e)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
                }
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.STATIC_FINAL_TRUE)
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.trim();
            IO.writeLine(stringTrimmed);
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.STATIC_FINAL_TRUE to IO.STATIC_FINAL_FALSE */
    private void goodG2B1() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";

        }

        if (IO.STATIC_FINAL_TRUE)
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.trim();
            IO.writeLine(stringTrimmed);
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.STATIC_FINAL_TRUE)
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.trim();
            IO.writeLine(stringTrimmed);
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.STATIC_FINAL_TRUE to IO.STATIC_FINAL_FALSE */
    private void goodB2G1() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
        {
            FileInputStream streamFileInput = null;
            String propertiesFileName = "./CWE690_NULL_Deref_From_Return__Helper.properties";
            try
            {
                streamFileInput = new FileInputStream(propertiesFileName);
                Properties properties = new Properties();
                properties.load(streamFileInput);
                /* POTENTIAL FLAW: data may be set to null */
                data = properties.getProperty("CWE690");
            }
            catch (IOException exceptIO)
            {
                IO.writeLine("Could not open properties file: " + propertiesFileName);
                data = ""; /* ensure that data is initialized */
            }
            finally
            {
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException e)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
                }
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String stringTrimmed = data.trim();
                IO.writeLine(stringTrimmed);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
        {
            FileInputStream streamFileInput = null;
            String propertiesFileName = "./CWE690_NULL_Deref_From_Return__Helper.properties";
            try
            {
                streamFileInput = new FileInputStream(propertiesFileName);
                Properties properties = new Properties();
                properties.load(streamFileInput);
                /* POTENTIAL FLAW: data may be set to null */
                data = properties.getProperty("CWE690");
            }
            catch (IOException exceptIO)
            {
                IO.writeLine("Could not open properties file: " + propertiesFileName);
                data = ""; /* ensure that data is initialized */
            }
            finally
            {
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException e)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
                }
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.STATIC_FINAL_TRUE)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String stringTrimmed = data.trim();
                IO.writeLine(stringTrimmed);
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
