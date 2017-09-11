/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_console_readLine_67b.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: console_readLine Read count from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_console_readLine_67b
{
    public void badSink(CWE400_Resource_Exhaustion__sleep_console_readLine_67a.Container countContainer ) throws Throwable
    {
        int count = countContainer.containerOne;

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE400_Resource_Exhaustion__sleep_console_readLine_67a.Container countContainer ) throws Throwable
    {
        int count = countContainer.containerOne;

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(CWE400_Resource_Exhaustion__sleep_console_readLine_67a.Container countContainer ) throws Throwable
    {
        int count = countContainer.containerOne;

        /* FIX: Validate count before using it in a call to Thread.sleep() */
        if (count > 0 && count <= 2000)
        {
            Thread.sleep(count);
        }

    }
}
