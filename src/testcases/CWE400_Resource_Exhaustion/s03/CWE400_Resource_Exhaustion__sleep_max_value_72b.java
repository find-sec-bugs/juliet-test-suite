/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_max_value_72b.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: max_value Set count to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;
import java.util.Vector;

public class CWE400_Resource_Exhaustion__sleep_max_value_72b
{
    public void badSink(Vector<Integer> countVector ) throws Throwable
    {
        int count = countVector.remove(2);

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(Vector<Integer> countVector ) throws Throwable
    {
        int count = countVector.remove(2);

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(Vector<Integer> countVector ) throws Throwable
    {
        int count = countVector.remove(2);

        /* FIX: Validate count before using it in a call to Thread.sleep() */
        if (count > 0 && count <= 2000)
        {
            Thread.sleep(count);
        }

    }
}
