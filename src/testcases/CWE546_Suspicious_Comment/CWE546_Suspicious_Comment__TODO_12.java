/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__TODO_12.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: TODO
*    GoodSink: does not contain suspicious comment
*    BadSink : does not contain a suspicious comment
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

public class CWE546_Suspicious_Comment__TODO_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FLAW: This is the suspicious comment */
            /* TODO: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");
        }
        else
        {

            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");
        }
        else
        {

            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");

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
