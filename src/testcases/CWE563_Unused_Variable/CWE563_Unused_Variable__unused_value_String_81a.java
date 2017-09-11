/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_String_81a.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 563 Unused Variable
 * BadSource:  Initialize data
 * GoodSource: Initialize and use data
 * Sinks:
 *    GoodSink: Use data
 *    BadSink : re-initialize and use data
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_value_String_81a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = "Good";

        CWE563_Unused_Variable__unused_value_String_81_base baseObject = new CWE563_Unused_Variable__unused_value_String_81_bad();
        baseObject.action(data );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Initialize and use data before it is overwritten */

        data = "Good";

        IO.writeLine(data);

        CWE563_Unused_Variable__unused_value_String_81_base baseObject = new CWE563_Unused_Variable__unused_value_String_81_goodG2B();
        baseObject.action(data );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Initialize, but do not use data */

        data = "Good";

        CWE563_Unused_Variable__unused_value_String_81_base baseObject = new CWE563_Unused_Variable__unused_value_String_81_goodB2G();
        baseObject.action(data );
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
