/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE484_Omitted_Break_Statement_in_Switch__basic_01.java
Label Definition File: CWE484_Omitted_Break_Statement_in_Switch__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 484 Omitted Break Statement in Switch
* Sinks:
*    GoodSink: Each case in switch has a break statement
*    BadSink : Missing break statement in one case of switch
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE484_Omitted_Break_Statement_in_Switch;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE484_Omitted_Break_Statement_in_Switch__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
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

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
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

