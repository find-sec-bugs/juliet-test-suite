/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_console_readLine_22b.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: console_readLine Read count from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_console_readLine_22b
{
    public void badSink(int count ) throws Throwable
    {
        if (CWE400_Resource_Exhaustion__sleep_console_readLine_22a.badPublicStatic)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1Sink(int count ) throws Throwable
    {
        if (CWE400_Resource_Exhaustion__sleep_console_readLine_22a.goodB2G1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
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

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2Sink(int count ) throws Throwable
    {
        if (CWE400_Resource_Exhaustion__sleep_console_readLine_22a.goodB2G2PublicStatic)
        {
            /* FIX: Validate count before using it in a call to Thread.sleep() */
            if (count > 0 && count <= 2000)
            {
                Thread.sleep(count);
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int count ) throws Throwable
    {
        if (CWE400_Resource_Exhaustion__sleep_console_readLine_22a.goodG2BPublicStatic)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure count is inititialized before the Sink to avoid compiler errors */
            count = 0;
        }
    }
}
