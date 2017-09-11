/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_equals_52b.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: System_getProperty Set data to return of System.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_equals_52b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_52c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_52c()).goodB2GSink(data );
    }
}
