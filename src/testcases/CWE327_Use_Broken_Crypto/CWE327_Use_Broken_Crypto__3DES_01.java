/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE327_Use_Broken_Crypto__3DES_01.java
Label Definition File: CWE327_Use_Broken_Crypto.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 327 Use of Broken or Risky Cryptographic Algorithm
* Sinks: 3DES
*    GoodSink: use AES
*    BadSink : use 3DES
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE327_Use_Broken_Crypto;

import testcasesupport.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CWE327_Use_Broken_Crypto__3DES_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        final String CIPHER_INPUT = "ABCDEFG123456";

        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");

        /* Perform initialization of KeyGenerator */
        keyGenerator.init(112);

        SecretKey secretKey = keyGenerator.generateKey();
        byte[] byteKey = secretKey.getEncoded();

        /* FLAW: Use a weak crypto algorithm, 3DES */
        SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey, "DESede");

        Cipher tripleDesCipher = Cipher.getInstance("DESede");
        tripleDesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encrypted = tripleDesCipher.doFinal(CIPHER_INPUT.getBytes("UTF-8"));

        IO.writeLine(IO.toHex(encrypted));

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        final String CIPHER_INPUT = "ABCDEFG123456";

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

        /* Perform initialization of KeyGenerator */
        keyGenerator.init(128);

        SecretKey secretKey = keyGenerator.generateKey();
        byte[] byteKey = secretKey.getEncoded();

        /* FIX: Use a stronger crypto algorithm, AES */
        SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey, "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encrypted = aesCipher.doFinal(CIPHER_INPUT.getBytes("UTF-8"));

        IO.writeLine(IO.toHex(encrypted));

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

