/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__TODO_07.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: TODO
*    GoodSink: does not contain suspicious comment
*    BadSink : does not contain a suspicious comment
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

public class CWE546_Suspicious_Comment__TODO_07 extends AbstractTestCase
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
            /* FLAW: This is the suspicious comment */
            /* TODO: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");
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

            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateFive == 5)
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
