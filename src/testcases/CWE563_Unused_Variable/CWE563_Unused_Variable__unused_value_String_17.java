/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_String_17.java
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

public class CWE563_Unused_Variable__unused_value_String_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* We need to have one source outside of a for loop in order
         * to prevent the Java compiler from generating an error because
         * data is uninitialized
         */

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = "Good";

        for (int j = 0; j < 1; j++)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = "Reinitialize";
            IO.writeLine(data);
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Initialize and use data before it is overwritten */

        data = "Good";

        IO.writeLine(data);

        for (int j = 0; j < 1; j++)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = "Reinitialize";
            IO.writeLine(data);
        }
    }

    /* goodB2G() - use badsource and goodsink*/
    private void goodB2G() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = "Good";

        for (int k = 0; k < 1; k++)
        {
            /* FIX: Use data without over-writing its value */
            IO.writeLine(data);
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
