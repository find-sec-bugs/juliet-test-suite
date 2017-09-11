/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__listen_tcp_executeBatch_53d.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-53d.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: Use prepared statement and executeBatch (properly)
 *    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s03;
import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__listen_tcp_executeBatch_53d
{
    public void badSink(String data ) throws Throwable
    {

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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {

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

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {

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
