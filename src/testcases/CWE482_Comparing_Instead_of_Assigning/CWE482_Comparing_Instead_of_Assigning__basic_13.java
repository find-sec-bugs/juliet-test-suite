/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE482_Comparing_Instead_of_Assigning__basic_13.java
Label Definition File: CWE482_Comparing_Instead_of_Assigning__basic.label.xml
Template File: point-flaw-13.tmpl.java
*/
/*
* @description
* CWE: 482 Comparing Instead of Assigning
* Sinks:
*    GoodSink: Assigning
*    BadSink : Comparing instead of assigning
* Flow Variant: 13 Control flow: if(IO.STATIC_FINAL_FIVE==5) and if(IO.STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE482_Comparing_Instead_of_Assigning;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE482_Comparing_Instead_of_Assigning__basic_13 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE == 5)
        {
            int zeroOrOne = (new SecureRandom()).nextInt(2);
            boolean isZero = false;
            if((isZero == (zeroOrOne == 0)) == true) /* FLAW: should be (isZero = (zeroOrOne == 0)) */
            {
                IO.writeLine("zeroOrOne is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
    }

    /* good1() changes IO.STATIC_FINAL_FIVE==5 to IO.STATIC_FINAL_FIVE!=5 */
    private void good1() throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            int zeroOrOne = (new SecureRandom()).nextInt(2);

            boolean isZero = false;

            if((isZero = (zeroOrOne == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("zeroOrOne is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE == 5)
        {
            int zeroOrOne = (new SecureRandom()).nextInt(2);
            boolean isZero = false;
            if((isZero = (zeroOrOne == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("zeroOrOne is 0");
            }
            IO.writeLine("isZero is: " + isZero);
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
