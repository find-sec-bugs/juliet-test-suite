/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__util_17.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: util
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import java.security.SecureRandom;

import java.util.Random;

public class CWE338_Weak_PRNG__util_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        for(int j = 0; j < 1; j++)
        {
            /* FLAW: java.util.Random() is considered a weak PRNG */
            Random random = new Random();
            IO.writeLine("" + random.nextInt());
        }
    }

    /* good1() use the GoodSinkBody in the for statement */
    private void good1() throws Throwable
    {
        for(int k = 0; k < 1; k++)
        {
            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom secureRandom = new SecureRandom();
            IO.writeLine("" + secureRandom.nextDouble());
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
