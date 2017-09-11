/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__TODO_16.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: TODO
*    GoodSink: does not contain suspicious comment
*    BadSink : does not contain a suspicious comment
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

public class CWE546_Suspicious_Comment__TODO_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            /* FLAW: This is the suspicious comment */
            /* TODO: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");
            break;
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
