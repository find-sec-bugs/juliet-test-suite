/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE325_Missing_Required_Cryptographic_Step__KeyGenerator_init_16.java
Label Definition File: CWE325_Missing_Required_Cryptographic_Step.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 325 Missing Required Cryptographic Step
* Sinks: KeyGenerator_init
*    GoodSink: Include call to KeyGenerator.init()
*    BadSink : Missing call to KeyGenerator.init()
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE325_Missing_Required_Cryptographic_Step;

import testcasesupport.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CWE325_Missing_Required_Cryptographic_Step__KeyGenerator_init_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            /* FLAW: Skip initialization of KeyGenerator (like 'keyGenerator.init(128);')
             * According to the KeyGenerator JavaDoc: "In case the client does not explicitly
             * initialize the KeyGenerator (via a call to an init method), each provider must
             * supply (and document) a default initialization." This means that the cryptographic
             * provider will decide what length the key will be (128, 192, or 256 bits for AES)
             * which may cause a smaller key than desired to be used and may cause interoperability
             * issues when different providers are used.
             */
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey, "AES");
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = aesCipher.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            /* FIX: Perform initialization of KeyGenerator */
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey, "AES");
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = aesCipher.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
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
