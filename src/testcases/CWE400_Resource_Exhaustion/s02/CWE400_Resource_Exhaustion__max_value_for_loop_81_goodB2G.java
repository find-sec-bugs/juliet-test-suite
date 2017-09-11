/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__max_value_for_loop_81_goodB2G.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: max_value Set count to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE400_Resource_Exhaustion__max_value_for_loop_81_goodB2G extends CWE400_Resource_Exhaustion__max_value_for_loop_81_base
{
    public void action(int count ) throws Throwable
    {

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
