/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_StringBuilder_17.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* GoodSource: Initialize and use data
* Sinks:
*    GoodSink: Use data
*    BadSink : re-initialize and use data
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_value_StringBuilder_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        StringBuilder data;

        /* We need to have one source outside of a for loop in order
         * to prevent the Java compiler from generating an error because
         * data is uninitialized
         */

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = new StringBuilder("Good");

        for (int j = 0; j < 1; j++)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = new StringBuilder("Reinitialize");
            IO.writeLine(data.toString());
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;

        /* FIX: Initialize and use data before it is overwritten */

        data = new StringBuilder("Good");

        IO.writeLine(data.toString());

        for (int j = 0; j < 1; j++)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = new StringBuilder("Reinitialize");
            IO.writeLine(data.toString());
        }
    }

    /* goodB2G() - use badsource and goodsink*/
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = new StringBuilder("Good");

        for (int k = 0; k < 1; k++)
        {
            /* FIX: Use data without over-writing its value */
            IO.writeLine(data.toString());
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
