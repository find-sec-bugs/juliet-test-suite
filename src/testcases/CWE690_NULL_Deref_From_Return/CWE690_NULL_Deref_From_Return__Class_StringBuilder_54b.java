/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_StringBuilder_54b.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

public class CWE690_NULL_Deref_From_Return__Class_StringBuilder_54b
{
    public void badSink(StringBuilder data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Class_StringBuilder_54c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(StringBuilder data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Class_StringBuilder_54c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(StringBuilder data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Class_StringBuilder_54c()).goodB2GSink(data );
    }
}
