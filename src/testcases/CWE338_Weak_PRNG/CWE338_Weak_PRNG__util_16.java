/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__util_16.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: util
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import java.security.SecureRandom;

import java.util.Random;

public class CWE338_Weak_PRNG__util_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            /* FLAW: java.util.Random() is considered a weak PRNG */
            Random random = new Random();
            IO.writeLine("" + random.nextInt());
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom secureRandom = new SecureRandom();
            IO.writeLine("" + secureRandom.nextDouble());
            break;
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
