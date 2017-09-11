/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_81_base.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_81_base
{
    public abstract void action(String data ) throws Throwable;
}
