/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_int_16.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* GoodSource: Initialize and use data
* Sinks:
*    GoodSink: Use data
*    BadSink : re-initialize and use data
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_value_int_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        while (true)
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = 5;
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = 10;
            IO.writeLine("" + data);
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        while (true)
        {
            /* FIX: Initialize and use data before it is overwritten */
            data = 5;
            IO.writeLine("" + data);
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = 10;
            IO.writeLine("" + data);
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        while (true)
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = 5;
            break;
        }

        while (true)
        {
            /* FIX: Use data without over-writing its value */
            IO.writeLine("" + data);
            break;
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
