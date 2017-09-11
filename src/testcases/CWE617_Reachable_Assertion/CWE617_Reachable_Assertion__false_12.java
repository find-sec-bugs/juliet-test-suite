/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__false_12.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 617 Assertion is reachable
* Sinks: false
*    GoodSink: assert true, which will never trigger
*    BadSink : assert false, which will always trigger
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

public class CWE617_Reachable_Assertion__false_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FLAW: this assertion can be reached, and will always trigger (if code is compiled using -ea option to enable assert) */
            assert false; /* INCIDENTAL: CWE 571 - expression is always true - it's "true" because assert(e) basically does if (!(e)) */
        }
        else
        {

            /* FIX: ensure assertions cannot be triggered, in this case, to avoid an empty
             * function, assert true */
            assert true; /* INCIDENTAL: CWE 570 - expression is always false - it's "false" because assert(e) basically does if (!(e)) */

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FIX: ensure assertions cannot be triggered, in this case, to avoid an empty
             * function, assert true */
            assert true; /* INCIDENTAL: CWE 570 - expression is always false - it's "false" because assert(e) basically does if (!(e)) */
        }
        else
        {

            /* FIX: ensure assertions cannot be triggered, in this case, to avoid an empty
             * function, assert true */
            assert true; /* INCIDENTAL: CWE 570 - expression is always false - it's "false" because assert(e) basically does if (!(e)) */

        }
    }

    public void good() throws Throwable
    {
        good1();
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
