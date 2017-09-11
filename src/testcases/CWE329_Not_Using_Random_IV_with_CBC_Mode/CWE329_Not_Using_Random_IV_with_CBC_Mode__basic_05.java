/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_05.java
Label Definition File: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 329 Not using random IV with CBC Mode
* Sinks:
*    GoodSink: use random iv
*    BadSink : use hardcoded iv
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE329_Not_Using_Random_IV_with_CBC_Mode;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_05 extends AbstractTestCase
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
            byte[] text = "asdf".getBytes("UTF-8");
            byte[] initializationVector =
            {
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00
            };
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey key = keyGenerator.generateKey();
            /* FLAW: hardcoded initialization vector used */
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            IO.writeLine(IO.toHex(cipher.doFinal(text)));
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

            byte[] text = "asdf".getBytes("UTF-8");

            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey key = keyGenerator.generateKey();

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            int blockSize = cipher.getBlockSize();
            byte[] initializationVector = new byte[blockSize];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(initializationVector);

            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);

            IO.writeLine(IO.toHex(cipher.doFinal(text)));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateTrue)
        {
            byte[] text = "asdf".getBytes("UTF-8");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey key = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] initializationVector = new byte[blockSize];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(initializationVector);
            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            IO.writeLine(IO.toHex(cipher.doFinal(text)));
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
