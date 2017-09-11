/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_StringBuilder_68b.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

public class CWE690_NULL_Deref_From_Return__Class_StringBuilder_68b
{
    public void badSink() throws Throwable
    {
        StringBuilder data = CWE690_NULL_Deref_From_Return__Class_StringBuilder_68a.data;

        /* POTENTIAL FLAW: data could be null */
        String stringTrimmed = data.toString().trim();

        IO.writeLine(stringTrimmed);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        StringBuilder data = CWE690_NULL_Deref_From_Return__Class_StringBuilder_68a.data;

        /* POTENTIAL FLAW: data could be null */
        String stringTrimmed = data.toString().trim();

        IO.writeLine(stringTrimmed);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        StringBuilder data = CWE690_NULL_Deref_From_Return__Class_StringBuilder_68a.data;

        /* FIX: explicit check for null */
        if (data != null)
        {
            String stringTrimmed = data.toString().trim();
            IO.writeLine(stringTrimmed);
        }

    }
}
