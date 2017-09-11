/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_random_13.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-13.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: random Set count to a random value
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks:
*    GoodSink: Validate count before using it as a parameter in sleep function
*    BadSink : Use count as the parameter for sleep withhout checking it's size first
* Flow Variant: 13 Control flow: if(IO.STATIC_FINAL_FIVE==5) and if(IO.STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__sleep_random_13 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_FIVE==5)
        {
            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (IO.STATIC_FINAL_FIVE==5)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.STATIC_FINAL_FIVE==5 to IO.STATIC_FINAL_FIVE!=5 */
    private void goodG2B1() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_FIVE!=5)
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

        if (IO.STATIC_FINAL_FIVE==5)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_FIVE==5)
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

        if (IO.STATIC_FINAL_FIVE==5)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.STATIC_FINAL_FIVE==5 to IO.STATIC_FINAL_FIVE!=5 */
    private void goodB2G1() throws Throwable
    {
        int count;
        if (IO.STATIC_FINAL_FIVE==5)
        {
            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (IO.STATIC_FINAL_FIVE!=5)
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
        if (IO.STATIC_FINAL_FIVE==5)
        {
            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }

        if (IO.STATIC_FINAL_FIVE==5)
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
