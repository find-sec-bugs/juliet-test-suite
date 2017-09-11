/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE483_Incorrect_Block_Delimitation__semicolon_01.java
Label Definition File: CWE483_Incorrect_Block_Delimitation.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 483 Incorrect Block Delimitation
* Sinks: semicolon
*    GoodSink: Absence of suspicious semicolon
*    BadSink : Suspicious semicolon before the if statement brace
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE483_Incorrect_Block_Delimitation;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE483_Incorrect_Block_Delimitation__semicolon_01 extends AbstractTestCase
{
    public void bad() throws Throwable
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

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
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

