/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_22b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: connect_tcp Read password using an outbound tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.sql.*;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Level;

public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_22b
{
    public void badSink(String password ) throws Throwable
    {
        if (CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_22a.badPublicStatic)
        {
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure password is inititialized before the Sink to avoid compiler errors */
            password = null;
        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1Sink(String password ) throws Throwable
    {
        if (CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_22a.goodB2G1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure password is inititialized before the Sink to avoid compiler errors */
            password = null;
        }
        else
        {

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
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2Sink(String password ) throws Throwable
    {
        if (CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_22a.goodB2G2PublicStatic)
        {
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure password is inititialized before the Sink to avoid compiler errors */
            password = null;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String password ) throws Throwable
    {
        if (CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_22a.goodG2BPublicStatic)
        {
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure password is inititialized before the Sink to avoid compiler errors */
            password = null;
        }
    }
}
