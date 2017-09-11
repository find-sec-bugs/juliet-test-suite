/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_01.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 319 Cleartext Transmission of Sensitive Information
* BadSource: connect_tcp Read password using an outbound tcp connection
* GoodSource: Set password to a hardcoded value (one that was not sent over the network)
* Sinks: driverManager
*    GoodSink: Decrypt the password from the source before using it in database connection
*    BadSink : Use password directly from source in database connection
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;

import java.sql.*;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;


public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* Read data using an outbound tcp connection */
        {
            Socket socket = null;
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;
            try
            {
                /* Read data using an outbound tcp connection */
                socket = new Socket("host.example.org", 39544);

                /* read input from socket */

                /* POTENTIAL FLAW: Read password using an outbound tcp connection */
                readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                password = readerBuffered.readLine();
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
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }

                /* clean up socket objects */
                try
                {
                    if (socket != null)
                    {
                        socket.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                }
            }
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try
        {
            /* POTENTIAL FLAW: use password directly in getConnection() */
            connection = DriverManager.getConnection("data-url", "root", password);
            preparedStatement = connection.prepareStatement("select * from test_table");
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error with database connection", exceptSql);
        }
        finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
            }

            try
            {
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
            }

            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String password;

        /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
        /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
        password = "Password1234!";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try
        {
            /* POTENTIAL FLAW: use password directly in getConnection() */
            connection = DriverManager.getConnection("data-url", "root", password);
            preparedStatement = connection.prepareStatement("select * from test_table");
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error with database connection", exceptSql);
        }
        finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
            }

            try
            {
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
            }

            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* Read data using an outbound tcp connection */
        {
            Socket socket = null;
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;
            try
            {
                /* Read data using an outbound tcp connection */
                socket = new Socket("host.example.org", 39544);

                /* read input from socket */

                /* POTENTIAL FLAW: Read password using an outbound tcp connection */
                readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                password = readerBuffered.readLine();
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
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }

                /* clean up socket objects */
                try
                {
                    if (socket != null)
                    {
                        socket.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                }
            }
        }

        if (password != null)
        {
            /* FIX: Decrypt password before using in getConnection() */
            {
                Cipher aesCipher = Cipher.getInstance("AES");
                /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                password = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
            }
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try
            {
                /* POTENTIAL FLAW: use password directly in getConnection() */
                connection = DriverManager.getConnection("data-url", "root", password);
                preparedStatement = connection.prepareStatement("select * from test_table");
                resultSet = preparedStatement.executeQuery();
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
                }

                try
                {
                    if (preparedStatement != null)
                    {
                        preparedStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
                }

                try
                {
                    if (connection != null)
                    {
                        connection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }
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

