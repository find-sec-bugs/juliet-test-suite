/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_equals_68a.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: System_getProperty Set data to return of System.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_equals_68a extends AbstractTestCase
{
    public static String data;

    public void bad() throws Throwable
    {

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_68b()).badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_68b()).goodG2BSink();
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_68b()).goodB2GSink();
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
