/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__basic_74a.java
Label Definition File: CWE256_Plaintext_Storage_of_Password__basic.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource:  Read password from a .properties file (from the property named password)
 * GoodSource: Read password from a .properties file (from the property named password) and then decrypt it
 * Sinks:
 *    GoodSink: Decrypt password and use decrypted password as password to connect to DB
 *    BadSink : Use password as password to connect to DB
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.util.logging.Level;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

public class CWE256_Plaintext_Storage_of_Password__basic_74a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* retrieve the property */
        Properties properties = new Properties();
        FileInputStream streamFileInput = null;
        try
        {
            streamFileInput = new FileInputStream("../common/config.properties");
            properties.load(streamFileInput);

            password = properties.getProperty("password");
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamFileInput != null)
                {
                    streamFileInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
            }
        }

        /* POTENTIAL FLAW: The raw password read from the .properties file is passed on (without being decrypted) */

        HashMap<Integer,String> passwordHashMap = new HashMap<Integer,String>();
        passwordHashMap.put(0, password);
        passwordHashMap.put(1, password);
        passwordHashMap.put(2, password);
        (new CWE256_Plaintext_Storage_of_Password__basic_74b()).badSink(passwordHashMap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* retrieve the property */
        Properties properties = new Properties();

        FileInputStream streamFileInput = null;
        try
        {
            streamFileInput = new FileInputStream("../common/config.properties");
            properties.load(streamFileInput);

            password = properties.getProperty("password");
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamFileInput != null)
                {
                    streamFileInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
            }
        }

        /* FIX: password is decrypted before being passed on */
        {
            Cipher aesCipher = Cipher.getInstance("AES");

            /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
            SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
            aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            String decryptedPassword = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
            password = decryptedPassword;
        }

        HashMap<Integer,String> passwordHashMap = new HashMap<Integer,String>();
        passwordHashMap.put(0, password);
        passwordHashMap.put(1, password);
        passwordHashMap.put(2, password);
        (new CWE256_Plaintext_Storage_of_Password__basic_74b()).goodG2BSink(passwordHashMap  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* retrieve the property */
        Properties properties = new Properties();
        FileInputStream streamFileInput = null;
        try
        {
            streamFileInput = new FileInputStream("../common/config.properties");
            properties.load(streamFileInput);

            password = properties.getProperty("password");
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamFileInput != null)
                {
                    streamFileInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
            }
        }

        /* POTENTIAL FLAW: The raw password read from the .properties file is passed on (without being decrypted) */

        HashMap<Integer,String> passwordHashMap = new HashMap<Integer,String>();
        passwordHashMap.put(0, password);
        passwordHashMap.put(1, password);
        passwordHashMap.put(2, password);
        (new CWE256_Plaintext_Storage_of_Password__basic_74b()).goodB2GSink(passwordHashMap  );
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
