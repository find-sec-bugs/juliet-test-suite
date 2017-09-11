/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Property_prepareStatement_71b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-71b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: prepareStatement
 *    GoodSink: Use prepared statement and execute (properly)
 *    BadSink : data concatenated into SQL statement used in prepareStatement() call, which could result in SQL Injection
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s04;
import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__Property_prepareStatement_71b
{
    public void badSink(Object dataObject ) throws Throwable
    {
        String data = (String)dataObject;

        Connection dbConnection = null;
        PreparedStatement sqlStatement = null;

        try
        {
            /* POTENTIAL FLAW: data concatenated into SQL statement used in prepareStatement() call, which could result in SQL Injection */
            dbConnection = IO.getDBConnection();
            sqlStatement = dbConnection.prepareStatement("insert into users (status) values ('updated') where name='"+data+"'");

            Boolean result = sqlStatement.execute();

            if (result)
            {
                IO.writeLine("Name, " + data + ", updated successfully");
            }
            else
            {
                IO.writeLine("Unable to update records for user: " + data);
            }
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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Object dataObject ) throws Throwable
    {
        String data = (String)dataObject;

        Connection dbConnection = null;
        PreparedStatement sqlStatement = null;

        try
        {
            /* POTENTIAL FLAW: data concatenated into SQL statement used in prepareStatement() call, which could result in SQL Injection */
            dbConnection = IO.getDBConnection();
            sqlStatement = dbConnection.prepareStatement("insert into users (status) values ('updated') where name='"+data+"'");

            Boolean result = sqlStatement.execute();

            if (result)
            {
                IO.writeLine("Name, " + data + ", updated successfully");
            }
            else
            {
                IO.writeLine("Unable to update records for user: " + data);
            }
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
    public void goodB2GSink(Object dataObject ) throws Throwable
    {
        String data = (String)dataObject;

        Connection dbConnection = null;
        PreparedStatement sqlStatement = null;

        try
        {
            /* FIX: Use prepared statement and execute (properly) */
            dbConnection = IO.getDBConnection();
            sqlStatement = dbConnection.prepareStatement("insert into users (status) values ('updated') where name=?");
            sqlStatement.setString(1, data);

            Boolean result = sqlStatement.execute();

            if (result)
            {
                IO.writeLine("Name, " + data + ", updated successfully");
            }
            else
            {
                IO.writeLine("Unable to update records for user: " + data);
            }
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
