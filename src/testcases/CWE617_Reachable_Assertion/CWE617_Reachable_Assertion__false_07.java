/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__false_07.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 617 Assertion is reachable
* Sinks: false
*    GoodSink: assert true, which will never trigger
*    BadSink : assert false, which will always trigger
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

public class CWE617_Reachable_Assertion__false_07 extends AbstractTestCase
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad() throws Throwable
    {
        if (privateFive == 5)
        {
            /* FLAW: this assertion can be reached, and will always trigger (if code is compiled using -ea option to enable assert) */
            assert false; /* INCIDENTAL: CWE 571 - expression is always true - it's "true" because assert(e) basically does if (!(e)) */
        }
    }

    /* good1() changes privateFive==5 to privateFive!=5 */
    private void good1() throws Throwable
    {
        if (privateFive != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: ensure assertions cannot be triggered, in this case, to avoid an empty
             * function, assert true */
            assert true; /* INCIDENTAL: CWE 570 - expression is always false - it's "false" because assert(e) basically does if (!(e)) */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateFive == 5)
        {
            /* FIX: ensure assertions cannot be triggered, in this case, to avoid an empty
             * function, assert true */
            assert true; /* INCIDENTAL: CWE 570 - expression is always false - it's "false" because assert(e) basically does if (!(e)) */
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
