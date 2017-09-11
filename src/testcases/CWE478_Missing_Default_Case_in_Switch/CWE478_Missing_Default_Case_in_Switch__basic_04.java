/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE478_Missing_Default_Case_in_Switch__basic_04.java
Label Definition File: CWE478_Missing_Default_Case_in_Switch__basic.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 478 Missing Default Case in Switch
* Sinks:
*    GoodSink: Use default case in switch statement
*    BadSink : No default case in a switch statement
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE) and if(PRIVATE_STATIC_FINAL_FALSE)
*
* */

package testcases.CWE478_Missing_Default_Case_in_Switch;

import testcasesupport.*;

import java.io.*;

import java.security.SecureRandom;

public class CWE478_Missing_Default_Case_in_Switch__basic_04 extends AbstractTestCase
{
    /* The two variables below are declared "final", so a tool should
     * be able to identify that reads of these will always return their
     * initialized values.
     */
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;
    private static final boolean PRIVATE_STATIC_FINAL_FALSE = false;

    public void bad() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_TRUE)
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
    }

    /* good1() changes PRIVATE_STATIC_FINAL_TRUE to PRIVATE_STATIC_FINAL_FALSE */
    private void good1() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
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
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_TRUE)
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
