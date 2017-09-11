/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__aes_encrypted_payload_01.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: aes_encrypted_payload
*    GoodSink: Use a plaintext command
*    BadSink : Use an AES encrypted payload in an attempt to hide the command
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.IOException;

import java.util.logging.Level;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE506_Embedded_Malicious_Code__aes_encrypted_payload_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: encrytped "calc.exe" */
        String payload = "0297b5eb43e3b81f9c737b353c3ade45";

        Cipher aesCipher = Cipher.getInstance("AES");
        /* INCIDENTAL: Hardcoded crypto */
        SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        /* Convert hex string to byte array without the use of a library
         * adopted from: http://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java */
        int payloadLength = payload.length();
        byte[] data = new byte[payloadLength/2];

        for (int i = 0; i < payloadLength; i+=2)
        {
            data[i/2] = (byte)((Character.digit(payload.charAt(i), 16) << 4) + Character.digit(payload.charAt(i+1), 16));
        }

        String decryptedPayload = new String(aesCipher.doFinal(data), "UTF-8");

        try
        {
            Runtime.getRuntime().exec(decryptedPayload);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error executing command", exceptIO);
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        /* FIX: plaintext command */
        String decodedPayload = "calc.exe";
        try
        {
            Runtime.getRuntime().exec(decodedPayload);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error executing command", exceptIO);
        }

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

