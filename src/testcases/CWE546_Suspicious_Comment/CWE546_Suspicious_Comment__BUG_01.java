/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__BUG_01.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: BUG
*    GoodSink: does not contain suspicious comment
*    BadSink : contains suspicious comment
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

public class CWE546_Suspicious_Comment__BUG_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: This is the suspicious comment */
        /* BUG: There is a bug at this location...I'm not sure why! */
        IO.writeLine("This a test of the emergency broadcast system");

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        /* FIX: don't have those types of comments :) */
        IO.writeLine("This a test of the emergency broadcast system");

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

