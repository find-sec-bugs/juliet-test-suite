/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__math_10.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: math
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE338_Weak_PRNG__math_10 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticTrue)
        {
            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());
        }
    }

    /* good1() changes IO.staticTrue to IO.staticFalse */
    private void good1() throws Throwable
    {
        if (IO.staticFalse)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom secureRandom = new SecureRandom();

            IO.writeLine("" + secureRandom.nextDouble());

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (IO.staticTrue)
        {
            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom secureRandom = new SecureRandom();
            IO.writeLine("" + secureRandom.nextDouble());
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
