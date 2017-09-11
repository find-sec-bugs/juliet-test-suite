/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE481_Assigning_Instead_of_Comparing__basic_01.java
Label Definition File: CWE481_Assigning_Instead_of_Comparing__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 481 Assigning Instead of Comparing
* Sinks:
*    GoodSink: Comparing
*    BadSink : Assigning instead of comparing
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE481_Assigning_Instead_of_Comparing;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE481_Assigning_Instead_of_Comparing__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        int zeroOrOne = (new SecureRandom()).nextInt(2);

        boolean isZero = (zeroOrOne == 0);

        if(isZero = true) /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
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

        int zeroOrOne = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

        boolean isZero = (zeroOrOne == 0);

        if(isZero == true) /* FIX: using == instead of = */
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

