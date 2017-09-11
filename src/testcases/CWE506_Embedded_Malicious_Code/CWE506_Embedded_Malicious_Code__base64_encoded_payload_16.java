/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__base64_encoded_payload_16.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: base64_encoded_payload
*    GoodSink: Use a plaintext command
*    BadSink : Use a base64 encoded payload in an attempt to hide the command
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

import java.util.logging.Level;

public class CWE506_Embedded_Malicious_Code__base64_encoded_payload_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            /* FLAW: encoded "calc.exe" */
            String encodedPayload = "Y2FsYy5leGU=";
            try
            {
                Runtime.getRuntime().exec(new String(Base64.decodeBase64(encodedPayload), "UTF-8"));
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error executing command", exceptIO);
            }
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
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
