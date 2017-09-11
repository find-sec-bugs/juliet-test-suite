/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_Environment_sub_04.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: sub
*    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
*    BadSink : Subtract 1 from data, which can cause an Underflow
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE) and if(PRIVATE_STATIC_FINAL_FALSE)
*
* */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

public class CWE191_Integer_Underflow__int_Environment_sub_04 extends AbstractTestCase
{
    /* The two variables below are declared "final", so a tool should
     * be able to identify that reads of these will always return their
     * initialized values.
     */
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;
    private static final boolean PRIVATE_STATIC_FINAL_FALSE = false;

    public void bad() throws Throwable
    {
        int data;
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
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
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first PRIVATE_STATIC_FINAL_TRUE to PRIVATE_STATIC_FINAL_FALSE */
    private void goodG2B1() throws Throwable
    {
        int data;
        if (PRIVATE_STATIC_FINAL_FALSE)
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

        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        if (PRIVATE_STATIC_FINAL_TRUE)
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

        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second PRIVATE_STATIC_FINAL_TRUE to PRIVATE_STATIC_FINAL_FALSE */
    private void goodB2G1() throws Throwable
    {
        int data;
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
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
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        if (PRIVATE_STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
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
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
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
