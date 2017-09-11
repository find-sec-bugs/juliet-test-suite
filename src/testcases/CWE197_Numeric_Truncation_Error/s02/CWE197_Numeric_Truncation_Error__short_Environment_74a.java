/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_Environment_74a.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-74a.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s02;
import testcasesupport.*;
import java.util.HashMap;

import java.util.logging.Level;

public class CWE197_Numeric_Truncation_Error__short_Environment_74a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        short data;

        data = Short.MIN_VALUE; /* Initialize data */

        /* get environment variable ADD */
        /* FLAW: Read data from an environment variable */
        {
            String stringNumber = System.getenv("ADD");
            if (stringNumber != null) // avoid NPD incidental warnings
            {
                try
                {
                    data = Short.parseShort(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }
        }

        HashMap<Integer,Short> dataHashMap = new HashMap<Integer,Short>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE197_Numeric_Truncation_Error__short_Environment_74b()).badSink(dataHashMap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        short data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        HashMap<Integer,Short> dataHashMap = new HashMap<Integer,Short>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE197_Numeric_Truncation_Error__short_Environment_74b()).goodG2BSink(dataHashMap  );
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
