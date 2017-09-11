/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_Environment_15.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: Environment Read count from an environment variable
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks:
*    GoodSink: Validate count before using it as a parameter in sleep function
*    BadSink : Use count as the parameter for sleep withhout checking it's size first
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__sleep_Environment_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;

        switch (6)
        {
        case 6:
            count = Integer.MIN_VALUE; /* Initialize count */
            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read count from an environment variable */
            {
                String stringNumber = System.getenv("ADD");
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
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
            break;
        }

        switch (7)
        {
        case 7:
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        int count;

        switch (5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
            break;
        default:
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
            break;
        }

        switch (7)
        {
        case 7:
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        int count;

        switch (6)
        {
        case 6:
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
            break;
        }

        switch (7)
        {
        case 7:
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        int count;

        switch (6)
        {
        case 6:
            count = Integer.MIN_VALUE; /* Initialize count */
            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read count from an environment variable */
            {
                String stringNumber = System.getenv("ADD");
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
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
            break;
        }

        switch (8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        default:
            /* FIX: Validate count before using it in a call to Thread.sleep() */
            if (count > 0 && count <= 2000)
            {
                Thread.sleep(count);
            }
            break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        int count;

        switch (6)
        {
        case 6:
            count = Integer.MIN_VALUE; /* Initialize count */
            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read count from an environment variable */
            {
                String stringNumber = System.getenv("ADD");
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
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
            break;
        }

        switch (7)
        {
        case 7:
            /* FIX: Validate count before using it in a call to Thread.sleep() */
            if (count > 0 && count <= 2000)
            {
                Thread.sleep(count);
            }
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
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
