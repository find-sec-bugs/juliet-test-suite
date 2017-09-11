/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_72b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-72b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: driverManager
 *    BadSink : data used as password in database connection
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;
import java.util.Vector;

import java.util.logging.Level;
import java.io.*;

import java.sql.*;

public class CWE259_Hard_Coded_Password__driverManager_72b
{
    public void badSink(Vector<String> dataVector ) throws Throwable
    {
        String data = dataVector.remove(2);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (data != null)
        {
            try
            {
                /* POTENTIAL FLAW: data used as password in database connection */
                connection = DriverManager.getConnection("data-url", "root", data);
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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Vector<String> dataVector ) throws Throwable
    {
        String data = dataVector.remove(2);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (data != null)
        {
            try
            {
                /* POTENTIAL FLAW: data used as password in database connection */
                connection = DriverManager.getConnection("data-url", "root", data);
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
