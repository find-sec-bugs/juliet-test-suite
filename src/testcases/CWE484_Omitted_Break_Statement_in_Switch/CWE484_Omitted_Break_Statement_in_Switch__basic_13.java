/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE484_Omitted_Break_Statement_in_Switch__basic_13.java
Label Definition File: CWE484_Omitted_Break_Statement_in_Switch__basic.label.xml
Template File: point-flaw-13.tmpl.java
*/
/*
* @description
* CWE: 484 Omitted Break Statement in Switch
* Sinks:
*    GoodSink: Each case in switch has a break statement
*    BadSink : Missing break statement in one case of switch
* Flow Variant: 13 Control flow: if(IO.STATIC_FINAL_FIVE==5) and if(IO.STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE484_Omitted_Break_Statement_in_Switch;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE484_Omitted_Break_Statement_in_Switch__basic_13 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE == 5)
        {
            int intRandom = (new SecureRandom()).nextInt(3);
            String stringValue;
            switch (intRandom)
            {
            case 1:
                stringValue = "one";
                break;
            case 2:
                stringValue = "two"; /* INCIDENTAL: CWE563 Unused Variable (actually unused value) since s gets overwritten in the default case */
                /* FLAW: Case 2 is missing a break statement */
            default:
                stringValue = "Default";
                break;
            }
            IO.writeLine(stringValue);
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

            int intRandom = (new SecureRandom()).nextInt(3);
            String stringValue;

            switch (intRandom)
            {
            case 1:
                stringValue = "one";
                break;
            case 2:
                stringValue = "two";
                break; /* FIX: Case 2 has a break statement */
            default:
                stringValue = "Default";
                break;
            }

            IO.writeLine(stringValue);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE == 5)
        {
            int intRandom = (new SecureRandom()).nextInt(3);
            String stringValue;
            switch (intRandom)
            {
            case 1:
                stringValue = "one";
                break;
            case 2:
                stringValue = "two";
                break; /* FIX: Case 2 has a break statement */
            default:
                stringValue = "Default";
                break;
            }
            IO.writeLine(stringValue);
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
