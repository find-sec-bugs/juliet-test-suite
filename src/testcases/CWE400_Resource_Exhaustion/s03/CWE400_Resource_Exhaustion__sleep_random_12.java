/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_random_12.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: random Set count to a random value
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks:
*    GoodSink: Validate count before using it as a parameter in sleep function
*    BadSink : Use count as the parameter for sleep withhout checking it's size first
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__sleep_random_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
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

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
     * both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        int count;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
        else
        {

            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
     * both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        int count;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();
        }
        else
        {

            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* FIX: Validate count before using it in a call to Thread.sleep() */
            if (count > 0 && count <= 2000)
            {
                Thread.sleep(count);
            }
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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
