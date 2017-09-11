/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__random_for_loop_31.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__random_for_loop_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int countCopy;
        {
            int count;

            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();

            countCopy = count;
        }
        {
            int count = countCopy;

            int i = 0;

            /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int countCopy;
        {
            int count;

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

            countCopy = count;
        }
        {
            int count = countCopy;

            int i = 0;

            /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int countCopy;
        {
            int count;

            /* POTENTIAL FLAW: Set count to a random value */
            count = (new SecureRandom()).nextInt();

            countCopy = count;
        }
        {
            int count = countCopy;

            int i = 0;

            /* FIX: Validate count before using it as the for loop variant */
            if (count > 0 && count <= 20)
            {
                for (i = 0; i < count; i++)
                {
                    IO.writeLine("Hello");
                }
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
