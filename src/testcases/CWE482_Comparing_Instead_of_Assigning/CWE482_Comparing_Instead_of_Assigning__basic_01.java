/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE482_Comparing_Instead_of_Assigning__basic_01.java
Label Definition File: CWE482_Comparing_Instead_of_Assigning__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 482 Comparing Instead of Assigning
* Sinks:
*    GoodSink: Assigning
*    BadSink : Comparing instead of assigning
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE482_Comparing_Instead_of_Assigning;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE482_Comparing_Instead_of_Assigning__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        int zeroOrOne = (new SecureRandom()).nextInt(2);

        boolean isZero = false;

        if((isZero == (zeroOrOne == 0)) == true) /* FLAW: should be (isZero = (zeroOrOne == 0)) */
        {
            IO.writeLine("zeroOrOne is 0");
        }

        IO.writeLine("isZero is: " + isZero);

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        int zeroOrOne = (new SecureRandom()).nextInt(2);

        boolean isZero = false;

        if((isZero = (zeroOrOne == 0)) == true) /* FIX: correct assignment */
        {
            IO.writeLine("zeroOrOne is 0");
        }

        IO.writeLine("isZero is: " + isZero);

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

