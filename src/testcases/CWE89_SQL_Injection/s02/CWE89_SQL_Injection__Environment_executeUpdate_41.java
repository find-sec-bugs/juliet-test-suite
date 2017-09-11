/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Environment_executeUpdate_41.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: executeUpdate
 *    GoodSink: Use prepared statement and executeUpdate (properly)
 *    BadSink : data concatenated into SQL statement used in executeUpdate(), which could result in SQL Injection
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE89_SQL_Injection.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__Environment_executeUpdate_41 extends AbstractTestCase
{
    private void badSink(String data ) throws Throwable
    {

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

    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        badSink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink(String data ) throws Throwable
    {

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
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2BSink(data  );
    }

    private void goodB2GSink(String data ) throws Throwable
    {

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        goodB2GSink(data  );
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
