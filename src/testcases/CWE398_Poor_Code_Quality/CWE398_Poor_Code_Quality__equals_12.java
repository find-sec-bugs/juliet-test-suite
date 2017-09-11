/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_12.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__equals_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            int intOne = 1;
            IO.writeLine(intOne);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            intOne = intOne;
            IO.writeLine(intOne);
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            int intOne = 1, intFive = 5;
            IO.writeLine(intOne);
            /* FIX: Assign intFive to intOne */
            intOne = intFive;
            IO.writeLine(intOne);
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
