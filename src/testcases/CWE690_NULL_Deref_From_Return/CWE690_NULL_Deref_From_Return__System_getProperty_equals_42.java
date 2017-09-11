/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_equals_42.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: System_getProperty Set data to return of System.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_equals_42 extends AbstractTestCase
{
    private String badSource() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        return data;
    }

    public void bad() throws Throwable
    {
        String data = badSource();

        /* POTENTIAL FLAW: data could be null */
        if(data.equals("CWE690"))
        {
            IO.writeLine("data is CWE690");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private String goodG2BSource() throws Throwable
    {
        String data;

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        return data;
    }

    private void goodG2B() throws Throwable
    {
        String data = goodG2BSource();

        /* POTENTIAL FLAW: data could be null */
        if(data.equals("CWE690"))
        {
            IO.writeLine("data is CWE690");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private String goodB2GSource() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        return data;
    }

    private void goodB2G() throws Throwable
    {
        String data = goodB2GSource();

        /* FIX: call equals() on string literal (that is not null) */
        if("CWE690".equals(data))
        {
            IO.writeLine("data is CWE690");
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
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
