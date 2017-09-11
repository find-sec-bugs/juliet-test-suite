/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE483_Incorrect_Block_Delimitation__semicolon_15.java
Label Definition File: CWE483_Incorrect_Block_Delimitation.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 483 Incorrect Block Delimitation
* Sinks: semicolon
*    GoodSink: Absence of suspicious semicolon
*    BadSink : Suspicious semicolon before the if statement brace
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE483_Incorrect_Block_Delimitation;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE483_Incorrect_Block_Delimitation__semicolon_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        switch (7)
        {
        case 7:
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
            break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch (7)
        {
        case 7:
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
