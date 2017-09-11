/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_07.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__equals_07 extends AbstractTestCase
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad() throws Throwable
    {
        if (privateFive == 5)
        {
            int intOne = 1;
            IO.writeLine(intOne);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            intOne = intOne;
            IO.writeLine(intOne);
        }
    }

    /* good1() changes privateFive==5 to privateFive!=5 */
    private void good1() throws Throwable
    {
        if (privateFive != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            int intOne = 1, intFive = 5;

            IO.writeLine(intOne);

            /* FIX: Assign intFive to intOne */
            intOne = intFive;

            IO.writeLine(intOne);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateFive == 5)
        {
            int intOne = 1, intFive = 5;
            IO.writeLine(intOne);
            /* FIX: Assign intFive to intOne */
            intOne = intFive;
            IO.writeLine(intOne);
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
