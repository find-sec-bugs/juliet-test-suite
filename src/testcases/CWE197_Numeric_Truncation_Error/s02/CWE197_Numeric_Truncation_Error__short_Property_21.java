/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_Property_21.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-21.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s02;
import testcasesupport.*;

import java.util.logging.Level;

public class CWE197_Numeric_Truncation_Error__short_Property_21 extends AbstractTestCase
{
    /* The variable below is used to drive control flow in the source function */
    private boolean badPrivate = false;

    public void bad() throws Throwable
    {
        short data;

        badPrivate = true;
        data = bad_source();

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }

    }

    private short bad_source() throws Throwable
    {
        short data;

        if (badPrivate)
        {
            data = Short.MIN_VALUE; /* Initialize data */
            /* get system property user.home */
            /* FLAW: Read data from a system property */
            {
                String stringNumber = System.getProperty("user.home");
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        return data;
    }

    /* The variables below are used to drive control flow in the source functions. */
    private boolean goodG2B1_private = false;
    private boolean goodG2B2_private = false;

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
    }

    /* goodG2B1() - use goodsource and badsink by setting the variable to false instead of true */
    private void goodG2B1() throws Throwable
    {
        short data;

        goodG2B1_private = false;
        data = goodG2B1_source();

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }

    }

    private short goodG2B1_source() throws Throwable
    {
        short data = 0;

        if (goodG2B1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }

        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    private void goodG2B2() throws Throwable
    {
        short data;

        goodG2B2_private = true;
        data = goodG2B2_source();

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }

    }

    private short goodG2B2_source() throws Throwable
    {
        short data = 0;

        if (goodG2B2_private)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        return data;
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
