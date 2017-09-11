/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__database_executeBatch_31.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: Use prepared statement and executeBatch (properly)
 *    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE89_SQL_Injection.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;

import java.sql.*;


public class CWE89_SQL_Injection__database_executeBatch_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String dataCopy;
        {
            String data;

            data = ""; /* Initialize data */

            /* Read data from a database */
            {
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;

                try
                {
                    /* setup the connection */
                    connection = IO.getDBConnection();

                    /* prepare and execute a (hardcoded) query */
                    preparedStatement = connection.prepareStatement("select name from users where id=0");
                    resultSet = preparedStatement.executeQuery();

                    /* POTENTIAL FLAW: Read data from a database query resultset */
                    data = resultSet.getString(1);
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", exceptSql);
                }
                finally
                {
                    /* Close database objects */
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

            dataCopy = data;
        }
        {
            String data = dataCopy;

            if (data != null)
            {
                String names[] = data.split("-");
                int successCount = 0;
                Connection dbConnection = null;
                Statement sqlStatement = null;
                try
                {
                    dbConnection = IO.getDBConnection();
                    sqlStatement = dbConnection.createStatement();
                    for (int i = 0; i < names.length; i++)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection */
                        sqlStatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                    }
                    int resultsArray[] = sqlStatement.executeBatch();
                    for (int i = 0; i < names.length; i++)
                    {
                        if (resultsArray[i] > 0)
                        {
                            successCount++;
                        }
                    }
                    IO.writeLine("Succeeded in " + successCount + " out of " + names.length + " queries.");
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
                }
                finally
                {
                    try
                    {
                        if (sqlStatement != null)
                        {
                            sqlStatement.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statament", exceptSql);
                    }

                    try
                    {
                        if (dbConnection != null)
                        {
                            dbConnection.close();
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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String dataCopy;
        {
            String data;

            /* FIX: Use a hardcoded string */
            data = "foo";

            dataCopy = data;
        }
        {
            String data = dataCopy;

            if (data != null)
            {
                String names[] = data.split("-");
                int successCount = 0;
                Connection dbConnection = null;
                Statement sqlStatement = null;
                try
                {
                    dbConnection = IO.getDBConnection();
                    sqlStatement = dbConnection.createStatement();
                    for (int i = 0; i < names.length; i++)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection */
                        sqlStatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                    }
                    int resultsArray[] = sqlStatement.executeBatch();
                    for (int i = 0; i < names.length; i++)
                    {
                        if (resultsArray[i] > 0)
                        {
                            successCount++;
                        }
                    }
                    IO.writeLine("Succeeded in " + successCount + " out of " + names.length + " queries.");
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
                }
                finally
                {
                    try
                    {
                        if (sqlStatement != null)
                        {
                            sqlStatement.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statament", exceptSql);
                    }

                    try
                    {
                        if (dbConnection != null)
                        {
                            dbConnection.close();
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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String dataCopy;
        {
            String data;

            data = ""; /* Initialize data */

            /* Read data from a database */
            {
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;

                try
                {
                    /* setup the connection */
                    connection = IO.getDBConnection();

                    /* prepare and execute a (hardcoded) query */
                    preparedStatement = connection.prepareStatement("select name from users where id=0");
                    resultSet = preparedStatement.executeQuery();

                    /* POTENTIAL FLAW: Read data from a database query resultset */
                    data = resultSet.getString(1);
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", exceptSql);
                }
                finally
                {
                    /* Close database objects */
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

            dataCopy = data;
        }
        {
            String data = dataCopy;

            if (data != null)
            {
                String names[] = data.split("-");
                int successCount = 0;
                Connection dbConnection = null;
                PreparedStatement sqlStatement = null;
                try
                {
                    /* FIX: Use prepared statement and executeBatch (properly) */
                    dbConnection = IO.getDBConnection();
                    sqlStatement = dbConnection.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                    for (int i = 0; i < names.length; i++)
                    {
                        sqlStatement.setString(1, names[i]);
                        sqlStatement.addBatch();
                    }
                    int resultsArray[] = sqlStatement.executeBatch();
                    for (int i = 0; i < names.length; i++)
                    {
                        if (resultsArray[i] > 0)
                        {
                            successCount++;
                        }
                    }
                    IO.writeLine("Succeeded in " + successCount + " out of " + names.length + " queries.");
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
                }
                finally
                {
                    try
                    {
                        if (sqlStatement != null)
                        {
                            sqlStatement.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
                    }

                    try
                    {
                        if (dbConnection != null)
                        {
                            dbConnection.close();
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
