/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__max_value_HashMap_45.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-45.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: max_value Set data to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashMap
 *    BadSink : Create a HashMap using data as the initial size
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.HashMap;

public class CWE789_Uncontrolled_Mem_Alloc__max_value_HashMap_45 extends AbstractTestCase
{
    private int dataBad;
    private int dataGoodG2B;

    private void badSink() throws Throwable
    {
        int data = dataBad;

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap intHashMap = new HashMap(data);

    }

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        int data;

        /* FLAW: Set data to Integer.MAX_VALUE */
        data = Integer.MAX_VALUE;

        dataBad = data;
        badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    private void goodG2BSink() throws Throwable
    {
        int data = dataGoodG2B;

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap intHashMap = new HashMap(data);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        dataGoodG2B = data;
        goodG2BSink();
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
