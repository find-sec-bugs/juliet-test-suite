/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_random_81_goodG2B.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_random_81_goodG2B extends CWE400_Resource_Exhaustion__sleep_random_81_base
{
    public void action(int count ) throws Throwable
    {

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }
}
