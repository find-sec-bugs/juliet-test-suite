/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE759_Unsalted_One_Way_Hash__basic_01.java
Label Definition File: CWE759_Unsalted_One_Way_Hash__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 759 Use of one-way hash with no salt
* Sinks:
*    GoodSink: use a sufficiently random salt
*    BadSink : SHA512 with no salt
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE759_Unsalted_One_Way_Hash;

import testcasesupport.*;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class CWE759_Unsalted_One_Way_Hash__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        MessageDigest hash = MessageDigest.getInstance("SHA-512");

        /* FLAW: SHA512 with no salt */
        byte[] hashValue = hash.digest("hash me".getBytes("UTF-8"));

        IO.writeLine(IO.toHex(hashValue));

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

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

