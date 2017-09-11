/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE483_Incorrect_Block_Delimitation__semicolon_05.java
Label Definition File: CWE483_Incorrect_Block_Delimitation.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 483 Incorrect Block Delimitation
* Sinks: semicolon
*    GoodSink: Absence of suspicious semicolon
*    BadSink : Suspicious semicolon before the if statement brace
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE483_Incorrect_Block_Delimitation;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE483_Incorrect_Block_Delimitation__semicolon_05 extends AbstractTestCase
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
            int x, y;
            x = (new SecureRandom()).nextInt(3);
            y = 0;
            /* FLAW: Suspicious semicolon before the if statement brace */
            if (x == 0);
            {
                IO.writeLine("x == 0");
                y = 1; /* do something other than just printing in block */
            }
            IO.writeLine(y);
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

            int x, y;

            x = (new SecureRandom()).nextInt(3);
            y = 0;

            /* FIX: Remove the suspicious semicolon before the if statement brace */
            if (x == 0)
            {
                IO.writeLine("x == 0");
                y = 1; /* do something other than just printing in block */
            }

            IO.writeLine(y);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateTrue)
        {
            int x, y;
            x = (new SecureRandom()).nextInt(3);
            y = 0;
            /* FIX: Remove the suspicious semicolon before the if statement brace */
            if (x == 0)
            {
                IO.writeLine("x == 0");
                y = 1; /* do something other than just printing in block */
            }
            IO.writeLine(y);
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
