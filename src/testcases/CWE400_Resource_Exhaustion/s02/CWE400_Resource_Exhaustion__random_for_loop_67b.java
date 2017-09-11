/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__random_for_loop_67b.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE400_Resource_Exhaustion__random_for_loop_67b
{
    public void badSink(CWE400_Resource_Exhaustion__random_for_loop_67a.Container countContainer ) throws Throwable
    {
        int count = countContainer.containerOne;

        int i = 0;

        /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
        for (i = 0; i < count; i++)
        {
            IO.writeLine("Hello");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE400_Resource_Exhaustion__random_for_loop_67a.Container countContainer ) throws Throwable
    {
        int count = countContainer.containerOne;

        int i = 0;

        /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
        for (i = 0; i < count; i++)
        {
            IO.writeLine("Hello");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(CWE400_Resource_Exhaustion__random_for_loop_67a.Container countContainer ) throws Throwable
    {
        int count = countContainer.containerOne;

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
