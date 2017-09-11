/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_StringBuilder_04.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* Sinks:
*    GoodSink: Use data
*    BadSink : do nothing
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE) and if(PRIVATE_STATIC_FINAL_FALSE)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_init_variable_StringBuilder_04 extends AbstractTestCase
{
    /* The two variables below are declared "final", so a tool should
     * be able to identify that reads of these will always return their
     * initialized values.
     */
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;
    private static final boolean PRIVATE_STATIC_FINAL_FALSE = false;

    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = new StringBuilder("Good");

        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            /* FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing PRIVATE_STATIC_FINAL_TRUE to PRIVATE_STATIC_FINAL_FALSE */
    private void goodB2G1() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = new StringBuilder("Good");

        if (PRIVATE_STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Use data */

            IO.writeLine(data.toString());

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in if  */
    private void goodB2G2() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = new StringBuilder("Good");

        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            /* FIX: Use data */
            IO.writeLine(data.toString());
        }
    }

    public void good() throws Throwable
    {
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
