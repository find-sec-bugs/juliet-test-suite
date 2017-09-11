/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__basic_01.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 760 Use of one-way hash with a predictable salt
* Sinks:
*    GoodSink: SHA512 with a sufficiently random salt
*    BadSink : SHA512 with a predictable salt
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

public class CWE760_Predictable_Salt_One_Way_Hash__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        Random random = new Random();

        MessageDigest hash = MessageDigest.getInstance("SHA-512");
        /* FLAW: SHA512 with a predictable salt */
        hash.update((Integer.toString(random.nextInt())).getBytes("UTF-8"));
        byte[] hashValue = hash.digest("hash me".getBytes("UTF-8"));

        IO.writeLine(IO.toHex(hashValue));

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        SecureRandom secureRandom = new SecureRandom();

        MessageDigest hash = MessageDigest.getInstance("SHA-512");
        /* FIX: Use a sufficiently random salt */
        SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
        hash.update(prng.generateSeed(32));
        byte[] hashValue = hash.digest("hash me".getBytes("UTF-8"));

        IO.writeLine(IO.toHex(hashValue));

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

