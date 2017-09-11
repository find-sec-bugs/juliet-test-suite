/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_uninit_variable_int_01.java
Label Definition File: CWE563_Unused_Variable__unused_uninit_variable.label.xml
Template File: source-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  don't initialize data
* Sinks:
*    GoodSink: init and use data
*    BadSink : do nothing
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_uninit_variable_int_01 extends AbstractTestCase
{
    /* use badsource and badsink */
    public void bad() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        /* FLAW: Don't initialize or use data */
        /* do nothing */
        ; /* empty statement needed for some flow variants */

    }

    public void good() throws Throwable
    {
        goodB2G();
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        /* FIX: Initialize then use data */

        data = 5;

        IO.writeLine("" + data);

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

