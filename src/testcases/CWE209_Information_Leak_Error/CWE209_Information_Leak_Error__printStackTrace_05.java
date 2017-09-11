/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_05.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace
*    GoodSink: Print generic error message to console
*    BadSink : Print stack trace to console
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

public class CWE209_Information_Leak_Error__printStackTrace_05 extends AbstractTestCase
{
    /* The two variables below are not defined as "final", but are never
     * assigned any other value, so a tool should be able to identify that
     * reads of these will always return their initialized values.
     */
    private boolean privateTrue = true;
    private boolean privateFalse = false;

    public void bad() throws Throwable
    {
        if (privateTrue)
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
    }

    /* good1() changes privateTrue to privateFalse */
    private void good1() throws Throwable
    {
        if (privateFalse)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
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
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateTrue)
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
    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
