/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_equals_21.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: System_getProperty Set data to return of System.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_equals_21 extends AbstractTestCase
{
    /* The variable below is used to drive control flow in the sink function */
    private boolean badPrivate = false;

    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        badPrivate = true;
        badSink(data );
    }

    private void badSink(String data ) throws Throwable
    {
        if (badPrivate)
        {
            /* POTENTIAL FLAW: data could be null */
            if(data.equals("CWE690"))
            {
                IO.writeLine("data is CWE690");
            }
        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1Private = false;
    private boolean goodB2G2Private = false;
    private boolean goodG2BPrivate = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        goodB2G1Private = false;
        goodB2G1Sink(data );
    }

    private void goodB2G1Sink(String data ) throws Throwable
    {
        if (goodB2G1Private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: call equals() on string literal (that is not null) */
            if("CWE690".equals(data))
            {
                IO.writeLine("data is CWE690");
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        goodB2G2Private = true;
        goodB2G2Sink(data );
    }

    private void goodB2G2Sink(String data ) throws Throwable
    {
        if (goodB2G2Private)
        {
            /* FIX: call equals() on string literal (that is not null) */
            if("CWE690".equals(data))
            {
                IO.writeLine("data is CWE690");
            }
        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        goodG2BPrivate = true;
        goodG2BSink(data );
    }

    private void goodG2BSink(String data ) throws Throwable
    {
        if (goodG2BPrivate)
        {
            /* POTENTIAL FLAW: data could be null */
            if(data.equals("CWE690"))
            {
                IO.writeLine("data is CWE690");
            }
        }
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
