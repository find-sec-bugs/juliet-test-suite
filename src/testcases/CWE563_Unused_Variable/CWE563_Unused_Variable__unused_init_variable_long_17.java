/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_long_17.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* Sinks:
*    GoodSink: Use data
*    BadSink : do nothing
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_init_variable_long_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = 5L;

        for (int j = 0; j < 1; j++)
        {
            /* FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the for statements */
    private void goodB2G() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = 5L;

        for (int k = 0; k < 1; k++)
        {
            /* FIX: Use data */
            IO.writeLine("" + data);
        }
    }

    public void good() throws Throwable
    {
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
