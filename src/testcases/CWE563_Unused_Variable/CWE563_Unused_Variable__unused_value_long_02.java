/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_long_02.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-02.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* GoodSource: Initialize and use data
* Sinks:
*    GoodSink: Use data
*    BadSink : re-initialize and use data
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_value_long_02 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        long data;
        if (true)
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = 5L;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (true)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = 10L;
            IO.writeLine("" + data);
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first true to false */
    private void goodG2B1() throws Throwable
    {
        long data;
        if (false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }
        else
        {

            /* FIX: Initialize and use data before it is overwritten */

            data = 5L;

            IO.writeLine("" + data);

        }

        if (true)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = 10L;
            IO.writeLine("" + data);
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        long data;
        if (true)
        {
            /* FIX: Initialize and use data before it is overwritten */
            data = 5L;
            IO.writeLine("" + data);
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (true)
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = 10L;
            IO.writeLine("" + data);
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second true to false */
    private void goodB2G1() throws Throwable
    {
        long data;
        if (true)
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = 5L;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Use data without over-writing its value */

            IO.writeLine("" + data);

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        long data;
        if (true)
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = 5L;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (true)
        {
            /* FIX: Use data without over-writing its value */
            IO.writeLine("" + data);
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
