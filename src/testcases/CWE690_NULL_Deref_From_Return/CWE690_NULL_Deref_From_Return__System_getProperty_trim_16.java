/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_trim_16.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource: System_getProperty Set data to return of System.getProperty
* GoodSource: Set data to fixed, non-null String
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_trim_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        while (true)
        {
            /* POTENTIAL FLAW: data may be set to null */
            data = System.getProperty("CWE690");
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.trim();
            IO.writeLine(stringTrimmed);
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        while (true)
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.trim();
            IO.writeLine(stringTrimmed);
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        while (true)
        {
            /* POTENTIAL FLAW: data may be set to null */
            data = System.getProperty("CWE690");
            break;
        }

        while (true)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String stringTrimmed = data.trim();
                IO.writeLine(stringTrimmed);
            }
            break;
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
