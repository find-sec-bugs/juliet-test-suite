/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_uninit_variable_String_12.java
Label Definition File: CWE563_Unused_Variable__unused_uninit_variable.label.xml
Template File: source-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  don't initialize data
* Sinks:
*    GoodSink: init and use data
*    BadSink : do nothing
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_uninit_variable_String_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if (IO.staticReturnsTrueOrFalse())
        {
            /* FLAW: Don't initialize or use data */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
        else
        {

            /* FIX: Initialize then use data */

            data = "Good";

            IO.writeLine(data);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the  "if" so that
       both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if (IO.staticReturnsTrueOrFalse())
        {
            /* FIX: Initialize then use data */
            data = "Good";
            IO.writeLine(data);
        }
        else
        {

            /* FIX: Initialize then use data */

            data = "Good";

            IO.writeLine(data);

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
