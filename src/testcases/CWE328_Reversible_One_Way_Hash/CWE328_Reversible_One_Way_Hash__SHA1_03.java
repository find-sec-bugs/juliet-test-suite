/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE328_Reversible_One_Way_Hash__SHA1_03.java
Label Definition File: CWE328_Reversible_One_Way_Hash.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 328 Reversible One Way Hash
* Sinks: SHA1
*    GoodSink: SHA512
*    BadSink : SHA1
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE328_Reversible_One_Way_Hash;

import testcasesupport.*;

import java.security.MessageDigest;

public class CWE328_Reversible_One_Way_Hash__SHA1_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (5 == 5)
        {
            String input = "Test Input";
            /* FLAW: Insecure cryptographic hashing algorithm (SHA1) */
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            byte[] hashValue = messageDigest.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashValue));
        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if (5 != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            String input = "Test Input";

            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] hashValue = messageDigest.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

            IO.writeLine(IO.toHex(hashValue));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (5 == 5)
        {
            String input = "Test Input";
            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] hashValue = messageDigest.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashValue));
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
