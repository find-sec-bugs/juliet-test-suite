/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_if_17.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_if
*    GoodSink: If statement contains code
*    BadSink : An empty if statement has no effect
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE398_Poor_Code_Quality__empty_if_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        for(int j = 0; j < 1; j++)
        {
            int x;
            x = (new SecureRandom()).nextInt();
            /* FLAW: An empty if statement has no effect */
            if (x == 0)
            {
            }
            else
            {
                IO.writeLine("Inside the else statement");
            }
            IO.writeLine("Hello from bad()");
        }
    }

    /* good1() use the GoodSinkBody in the for statement */
    private void good1() throws Throwable
    {
        for(int k = 0; k < 1; k++)
        {
            int x;
            x = (new SecureRandom()).nextInt();
            /* FIX: Do not include an empty if statement */
            if (x == 0)
            {
                IO.writeLine("Inside the if statement");
            }
            else
            {
                IO.writeLine("Inside the else statement");
            }
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
