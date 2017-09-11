/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_StringBuilder_12.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource:  Use a custom method which may return null
* GoodSource: Use a custom method that never returns null
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

public class CWE690_NULL_Deref_From_Return__Class_StringBuilder_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        StringBuilder data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Call getStringBuilderBad(), which may return null */
            data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderBad();
        }
        else
        {

            /* FIX: call getStringBuilderGood(), which will never return null */
            data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderGood();

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.toString().trim();
            IO.writeLine(stringTrimmed);
        }
        else
        {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String stringTrimmed = data.toString().trim();
                IO.writeLine(stringTrimmed);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
     * both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* FIX: call getStringBuilderGood(), which will never return null */
            data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderGood();
        }
        else
        {

            /* FIX: call getStringBuilderGood(), which will never return null */
            data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderGood();

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.toString().trim();
            IO.writeLine(stringTrimmed);
        }
        else
        {

            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.toString().trim();

            IO.writeLine(stringTrimmed);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
     * both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Call getStringBuilderBad(), which may return null */
            data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderBad();
        }
        else
        {

            /* POTENTIAL FLAW: Call getStringBuilderBad(), which may return null */
            data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderBad();

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String stringTrimmed = data.toString().trim();
                IO.writeLine(stringTrimmed);
            }
        }
        else
        {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String stringTrimmed = data.toString().trim();
                IO.writeLine(stringTrimmed);
            }

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
