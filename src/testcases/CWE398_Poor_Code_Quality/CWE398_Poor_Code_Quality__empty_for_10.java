/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_for_10.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_for
*    GoodSink: For statement contains code
*    BadSink : An empty for statement has no effect
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__empty_for_10 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticTrue)
        {
            /* FLAW: An empty for statement has no effect */
            for (int i = 0; i < 10; i++)
            {
            }
            IO.writeLine("Hello from bad()");
        }
    }

    /* good1() changes IO.staticTrue to IO.staticFalse */
    private void good1() throws Throwable
    {
        if (IO.staticFalse)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Do not include an empty for statement */
            for (int i = 0; i < 10; i++)
            {
                IO.writeLine("Inside the for statement");
            }

            IO.writeLine("Hello from good()");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (IO.staticTrue)
        {
            /* FIX: Do not include an empty for statement */
            for (int i = 0; i < 10; i++)
            {
                IO.writeLine("Inside the for statement");
            }
            IO.writeLine("Hello from good()");
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
