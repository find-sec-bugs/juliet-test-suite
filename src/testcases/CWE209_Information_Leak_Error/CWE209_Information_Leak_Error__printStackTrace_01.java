/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_01.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace
*    GoodSink: Print generic error message to console
*    BadSink : Print stack trace to console
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

public class CWE209_Information_Leak_Error__printStackTrace_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        try
        {
            throw new UnsupportedOperationException();
        }
        catch (UnsupportedOperationException exceptUnsupportedOperation)
        {
            exceptUnsupportedOperation.printStackTrace(); /* FLAW: Print stack trace to console on error */
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        try
        {
            throw new UnsupportedOperationException();
        }
        catch (UnsupportedOperationException exceptUnsupportedOperation)
        {
            IO.writeLine("There was an unsupported operation error"); /* FIX: print a generic message */
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

