/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_uninit_variable_String_07.java
Label Definition File: CWE563_Unused_Variable__unused_uninit_variable.label.xml
Template File: source-sinks-07.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  don't initialize data
* Sinks:
*    GoodSink: init and use data
*    BadSink : do nothing
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_uninit_variable_String_07 extends AbstractTestCase
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if (privateFive == 5)
        {
            /* FLAW: Don't initialize or use data */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing privateFive==5 to privateFive!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if (privateFive != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Initialize then use data */

            data = "Good";

            IO.writeLine(data);

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in if  */
    private void goodB2G2() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if (privateFive == 5)
        {
            /* FIX: Initialize then use data */
            data = "Good";
            IO.writeLine(data);
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
