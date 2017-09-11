/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_05.java
Label Definition File: CWE325_Missing_Required_Cryptographic_Step.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 325 Missing Required Cryptographic Step
* Sinks: MessageDigest_update
*    GoodSink: Include call to MessageDigest.update()
*    BadSink : Missing call to MessageDigest.update()
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE325_Missing_Required_Cryptographic_Step;

import testcasesupport.*;

import java.security.MessageDigest;

public class CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_05 extends AbstractTestCase
{
    /* The two variables below are not defined as "final", but are never
     * assigned any other value, so a tool should be able to identify that
     * reads of these will always return their initialized values.
     */
    private boolean privateTrue = true;
    private boolean privateFalse = false;

    public void bad() throws Throwable
    {
        if (privateTrue)
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            /* FLAW: Missing call to MessageDigest.update().  This will result in the hash being of no data */
            IO.writeLine(IO.toHex(messageDigest.digest()));
        }
    }

    /* good1() changes privateTrue to privateFalse */
    private void good1() throws Throwable
    {
        if (privateFalse)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            final String HASH_INPUT = "ABCDEFG123456";

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

            /* FIX: Include call to MessageDigest.update() */
            messageDigest.update(HASH_INPUT.getBytes("UTF-8"));

            IO.writeLine(IO.toHex(messageDigest.digest()));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateTrue)
        {
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            /* FIX: Include call to MessageDigest.update() */
            messageDigest.update(HASH_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(messageDigest.digest()));
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
