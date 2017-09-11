/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__LATER_05.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: LATER
*    GoodSink: does not contain suspicious comment
*    BadSink : does not contain a suspicious comment
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

public class CWE546_Suspicious_Comment__LATER_05 extends AbstractTestCase
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
            /* FLAW: This is the suspicious comment */
            /* LATER: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");
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

            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");
        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateTrue)
        {
            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");
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
