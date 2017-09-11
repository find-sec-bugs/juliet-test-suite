/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_54c.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_54c
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_54d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_54d()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_54d()).goodB2GSink(data );
    }
}
