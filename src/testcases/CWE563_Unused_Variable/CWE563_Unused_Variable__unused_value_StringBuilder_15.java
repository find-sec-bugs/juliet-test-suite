/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_StringBuilder_15.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* GoodSource: Initialize and use data
* Sinks:
*    GoodSink: Use data
*    BadSink : re-initialize and use data
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_value_StringBuilder_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        StringBuilder data;

        switch (6)
        {
        case 6:
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = new StringBuilder("Good");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (7)
        {
        case 7:
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = new StringBuilder("Reinitialize");
            IO.writeLine(data.toString());
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        StringBuilder data;

        switch (5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        default:
            /* FIX: Initialize and use data before it is overwritten */
            data = new StringBuilder("Good");
            IO.writeLine(data.toString());
            break;
        }

        switch (7)
        {
        case 7:
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = new StringBuilder("Reinitialize");
            IO.writeLine(data.toString());
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        StringBuilder data;

        switch (6)
        {
        case 6:
            /* FIX: Initialize and use data before it is overwritten */
            data = new StringBuilder("Good");
            IO.writeLine(data.toString());
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (7)
        {
        case 7:
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = new StringBuilder("Reinitialize");
            IO.writeLine(data.toString());
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        StringBuilder data;

        switch (6)
        {
        case 6:
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = new StringBuilder("Good");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        default:
            /* FIX: Use data without over-writing its value */
            IO.writeLine(data.toString());
            break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        StringBuilder data;

        switch (6)
        {
        case 6:
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = new StringBuilder("Good");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (7)
        {
        case 7:
            /* FIX: Use data without over-writing its value */
            IO.writeLine(data.toString());
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
