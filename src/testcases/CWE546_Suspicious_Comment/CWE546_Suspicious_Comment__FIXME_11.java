/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__FIXME_11.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: FIXME
*    GoodSink: does not contain suspicious comment
*    BadSink : does not contain a suspicious comment
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

public class CWE546_Suspicious_Comment__FIXME_11 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrue())
        {
            /* FLAW: This is the suspicious comment */
            /* FIXME: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");
        }
    }

    /* good1() changes IO.staticReturnsTrue() to IO.staticReturnsFalse() */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsFalse())
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
        if (IO.staticReturnsTrue())
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
