/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__basic_81_goodB2G.java
Label Definition File: CWE256_Plaintext_Storage_of_Password__basic.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource:  Read password from a .properties file (from the property named password)
 * GoodSource: Read password from a .properties file (from the property named password) and then decrypt it
 * Sinks:
 *    GoodSink: Decrypt password and use decrypted password as password to connect to DB
 *    BadSink : Use password as password to connect to DB
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class CWE256_Plaintext_Storage_of_Password__basic_81_goodB2G extends CWE256_Plaintext_Storage_of_Password__basic_81_base
{
    public void action(String password ) throws Throwable
    {

        /* FIX: password is decrypted before being used as a database password */
        {
            Cipher aesCipher = Cipher.getInstance("AES");

            /* INCIDENTAL: Hardcoded crypto */
            SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
            aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            String decryptedPassword = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
            password = decryptedPassword;
        }

        Connection dBConnection = null;
        try
        {
            dBConnection = DriverManager.getConnection("192.168.105.23", "sa", password);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
            try
            {
                if (dBConnection != null)
                {
                    dBConnection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }
        }

    }
}
