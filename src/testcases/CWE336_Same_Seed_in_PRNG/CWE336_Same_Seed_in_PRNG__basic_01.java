/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE336_Same_Seed_in_PRNG__basic_01.java
Label Definition File: CWE336_Same_Seed_in_PRNG__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 336 Same Seed in PRNG
* Sinks:
*    GoodSink: no explicit seed specified
*    BadSink : hardcoded seed
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE336_Same_Seed_in_PRNG;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE336_Same_Seed_in_PRNG__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        final byte[] SEED = new byte[] {0x01, 0x02, 0x03, 0x04, 0x05};
        SecureRandom secureRandom = new SecureRandom();

        /* FLAW: using the same seed can make the PRNG sequence predictable if the seed is known */
        secureRandom.setSeed(SEED);

        IO.writeLine("" + secureRandom.nextInt()); /* run this several times and notice that the bad values are always the same */
        IO.writeLine("" + secureRandom.nextInt());

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        SecureRandom secureRandom = new SecureRandom();

        /* FIX: no explicit seed specified; produces far less predictable PRNG sequence */

        IO.writeLine("" + secureRandom.nextInt());
        IO.writeLine("" + secureRandom.nextInt());

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

