/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_driverManager_81_goodG2B.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: URLConnection Read password from a web server with URLConnection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.sql.*;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Level;

public class CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_driverManager_81_goodG2B extends CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_driverManager_81_base
{
    public void action(String password ) throws Throwable
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
}
