/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_81a.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-81a.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: max_value Set data to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: ArrayList
 *    BadSink : Create an ArrayList using data as the initial size
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_81a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        /* FLAW: Set data to Integer.MAX_VALUE */
        data = Integer.MAX_VALUE;

        CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_81_base baseObject = new CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_81_bad();
        baseObject.action(data );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_81_base baseObject = new CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_81_goodG2B();
        baseObject.action(data );
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
