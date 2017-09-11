/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Environment_execute_81_goodB2G.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: execute
 *    GoodSink: Use prepared statement and execute (properly)
 *    BadSink : data concatenated into SQL statement used in execute(), which could result in SQL Injection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE89_SQL_Injection.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__Environment_execute_81_goodB2G extends CWE89_SQL_Injection__Environment_execute_81_base
{
    public void action(String data ) throws Throwable
    {

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
