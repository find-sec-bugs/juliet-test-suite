/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE478_Missing_Default_Case_in_Switch__basic_01.java
Label Definition File: CWE478_Missing_Default_Case_in_Switch__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 478 Missing Default Case in Switch
* Sinks:
*    GoodSink: Use default case in switch statement
*    BadSink : No default case in a switch statement
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE478_Missing_Default_Case_in_Switch;

import testcasesupport.*;

import java.io.*;

import java.security.SecureRandom;

public class CWE478_Missing_Default_Case_in_Switch__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        String stringIntValue = "";
        int x = (new SecureRandom()).nextInt(3);

        switch (x)
        {
        case 0:
            stringIntValue = "0";
            break;
        case 1:
            stringIntValue = "1";
            break;
            /* FLAW: x could be 2, and there is no 'default' case for that */
        }

        IO.writeLine(stringIntValue);

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        String stringIntValue = "";
        int x = (new SecureRandom()).nextInt(3);

        switch (x)
        {
        case 0:
            stringIntValue = "0";
            break;
        case 1:
            stringIntValue = "1";
            break;
            /* FIX: Add a default case */
        default:
            stringIntValue = "2";
        }

        IO.writeLine(stringIntValue);

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

