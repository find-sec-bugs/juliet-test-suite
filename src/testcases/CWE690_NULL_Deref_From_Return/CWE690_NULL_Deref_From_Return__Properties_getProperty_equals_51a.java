/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_51a.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-51a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.util.logging.Level;

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_51a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

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

        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_51b()).badSink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_51b()).goodG2BSink(data  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

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

        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_51b()).goodB2GSink(data  );
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
