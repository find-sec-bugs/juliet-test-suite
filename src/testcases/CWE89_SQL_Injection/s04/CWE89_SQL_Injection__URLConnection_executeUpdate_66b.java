/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__URLConnection_executeUpdate_66b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: executeUpdate
 *    GoodSink: Use prepared statement and executeUpdate (properly)
 *    BadSink : data concatenated into SQL statement used in executeUpdate(), which could result in SQL Injection
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s04;
import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__URLConnection_executeUpdate_66b
{
    public void badSink(String dataArray[] ) throws Throwable
    {
        String data = dataArray[2];

        Connection dbConnection = null;
        Statement sqlStatement = null;

        try
        {
            dbConnection = IO.getDBConnection();
            sqlStatement = dbConnection.createStatement();

            /* POTENTIAL FLAW: data concatenated into SQL statement used in executeUpdate(), which could result in SQL Injection */
            int rowCount = sqlStatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");

            IO.writeLine("Updated " + rowCount + " rows successfully.");
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
                IO.logger.log(Level.WARNING, "Error closing Statement", exceptSql);
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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String dataArray[] ) throws Throwable
    {
        String data = dataArray[2];

        Connection dbConnection = null;
        Statement sqlStatement = null;

        try
        {
            dbConnection = IO.getDBConnection();
            sqlStatement = dbConnection.createStatement();

            /* POTENTIAL FLAW: data concatenated into SQL statement used in executeUpdate(), which could result in SQL Injection */
            int rowCount = sqlStatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");

            IO.writeLine("Updated " + rowCount + " rows successfully.");
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
                IO.logger.log(Level.WARNING, "Error closing Statement", exceptSql);
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

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String dataArray[] ) throws Throwable
    {
        String data = dataArray[2];

        Connection dbConnection = null;
        PreparedStatement sqlStatement = null;

        try
        {
            /* FIX: Use prepared statement and executeUpdate (properly) */
            dbConnection = IO.getDBConnection();
            sqlStatement = dbConnection.prepareStatement("insert into users (status) values ('updated') where name=?");
            sqlStatement.setString(1, data);

            int rowCount = sqlStatement.executeUpdate();

            IO.writeLine("Updated " + rowCount + " rows successfully.");
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
