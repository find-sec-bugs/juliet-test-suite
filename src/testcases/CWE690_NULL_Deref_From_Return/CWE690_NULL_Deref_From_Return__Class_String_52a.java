/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_String_52a.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-52a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

public class CWE690_NULL_Deref_From_Return__Class_String_52a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringBad(), which may return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBad();

        (new CWE690_NULL_Deref_From_Return__Class_String_52b()).badSink(data );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: call getStringGood(), which will never return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringGood();

        (new CWE690_NULL_Deref_From_Return__Class_String_52b()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringBad(), which may return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBad();

        (new CWE690_NULL_Deref_From_Return__Class_String_52b()).goodB2GSink(data );
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
