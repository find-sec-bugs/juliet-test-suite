/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_16.java
Label Definition File: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 329 Not using random IV with CBC Mode
* Sinks:
*    GoodSink: use random iv
*    BadSink : use hardcoded iv
* Flow Variant: 16 Control flow: while(true)
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

public class CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
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
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
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
