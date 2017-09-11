/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_Property_07.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-07.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: Property Read count from a system property
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks:
*    GoodSink: Validate count before using it as a parameter in sleep function
*    BadSink : Use count as the parameter for sleep withhout checking it's size first
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__sleep_Property_07 extends AbstractTestCase
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value. */
    private int privateFive = 5;

    public void bad() throws Throwable
    {
        int count;
        if (privateFive==5)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* get system property user.home */
            /* POTENTIAL FLAW: Read count from a system property */
            {
                String stringNumber = System.getProperty("user.home");
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (privateFive==5)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first privateFive==5 to privateFive!=5 */
    private void goodG2B1() throws Throwable
    {
        int count;
        if (privateFive!=5)
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

        if (privateFive==5)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int count;
        if (privateFive==5)
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

        if (privateFive==5)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second privateFive==5 to privateFive!=5 */
    private void goodB2G1() throws Throwable
    {
        int count;
        if (privateFive==5)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* get system property user.home */
            /* POTENTIAL FLAW: Read count from a system property */
            {
                String stringNumber = System.getProperty("user.home");
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (privateFive!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Validate count before using it in a call to Thread.sleep() */
            if (count > 0 && count <= 2000)
            {
                Thread.sleep(count);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int count;
        if (privateFive==5)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* get system property user.home */
            /* POTENTIAL FLAW: Read count from a system property */
            {
                String stringNumber = System.getProperty("user.home");
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (privateFive==5)
        {
            /* FIX: Validate count before using it in a call to Thread.sleep() */
            if (count > 0 && count <= 2000)
            {
                Thread.sleep(count);
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
