/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__int_Environment_to_byte_31.java
Label Definition File: CWE197_Numeric_Truncation_Error__int.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s01;
import testcasesupport.*;

import java.util.logging.Level;

public class CWE197_Numeric_Truncation_Error__int_Environment_to_byte_31 extends AbstractTestCase
{
    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        int dataCopy;
        {
            int data;

            data = Integer.MIN_VALUE; /* Initialize data */

            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            {
                String stringNumber = System.getenv("ADD");
                if (stringNumber != null) // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(stringNumber.trim());
                    }
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                    }
                }
            }

            dataCopy = data;
        }
        {
            int data = dataCopy;

            {
                /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
                IO.writeLine((byte)data);
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int dataCopy;
        {
            int data;

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

            dataCopy = data;
        }
        {
            int data = dataCopy;

            {
                /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
                IO.writeLine((byte)data);
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
