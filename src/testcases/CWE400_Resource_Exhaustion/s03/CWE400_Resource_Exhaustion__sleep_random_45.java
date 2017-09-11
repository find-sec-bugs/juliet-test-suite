/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_random_45.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__sleep_random_45 extends AbstractTestCase
{
    private int countBad;
    private int countGoodG2B;
    private int countGoodB2G;

    private void badSink() throws Throwable
    {
        int count = countBad;

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    public void bad() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        count = (new SecureRandom()).nextInt();

        countBad = count;
        badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink() throws Throwable
    {
        int count = countGoodG2B;

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        countGoodG2B = count;
        goodG2BSink();
    }

    private void goodB2GSink() throws Throwable
    {
        int count = countGoodB2G;

        /* FIX: Validate count before using it in a call to Thread.sleep() */
        if (count > 0 && count <= 2000)
        {
            Thread.sleep(count);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        count = (new SecureRandom()).nextInt();

        countGoodB2G = count;
        goodB2GSink();
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
