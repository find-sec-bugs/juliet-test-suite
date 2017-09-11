/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__semicolon_12.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: semicolon
*    GoodSink: Removed statement that has no effect
*    BadSink : A statement that has no effect
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__semicolon_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            ; /* FLAW: This semicolon is a statement that has no effect */
            IO.writeLine("Hello from bad()");
        }
        else
        {

            /* FIX: Do not include semicolon (statement that has no effect) */

            IO.writeLine("Hello from good()");

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FIX: Do not include semicolon (statement that has no effect) */
            IO.writeLine("Hello from good()");
        }
        else
        {

            /* FIX: Do not include semicolon (statement that has no effect) */

            IO.writeLine("Hello from good()");

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
