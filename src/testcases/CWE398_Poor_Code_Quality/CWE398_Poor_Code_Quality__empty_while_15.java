/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_while_15.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_while
*    GoodSink: While statement contains code
*    BadSink : An empty while statement has no effect
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__empty_while_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        switch (7)
        {
        case 7:
            int i = 0;
            /* FLAW: An empty while statement has no effect */
            while(i++ < 10)
            {
            }
            IO.writeLine("Hello from bad()");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch (8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        default:
            int i = 0;
            /* FIX: Do not include an empty while statement */
            while(i++ < 10)
            {
                IO.writeLine("Inside the while statement");
            }
            IO.writeLine("Hello from good()");
            break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch (7)
        {
        case 7:
            int i = 0;
            /* FIX: Do not include an empty while statement */
            while(i++ < 10)
            {
                IO.writeLine("Inside the while statement");
            }
            IO.writeLine("Hello from good()");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
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
