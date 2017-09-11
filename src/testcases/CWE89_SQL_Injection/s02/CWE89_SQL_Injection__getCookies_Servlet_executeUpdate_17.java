/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookies_Servlet_executeUpdate_17.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded string
* Sinks: executeUpdate
*    GoodSink: Use prepared statement and executeUpdate (properly)
*    BadSink : data concatenated into SQL statement used in executeUpdate(), which could result in SQL Injection
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE89_SQL_Injection.s02;
import testcasesupport.*;

import javax.servlet.http.*;


import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__getCookies_Servlet_executeUpdate_17 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* We need to have one source outside of a for loop in order
         * to prevent the Java compiler from generating an error because
         * data is uninitialized
         */

        data = ""; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                data = cookieSources[0].getValue();
            }
        }

        for (int j = 0; j < 1; j++)
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
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        for (int j = 0; j < 1; j++)
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
    }

    /* goodB2G() - use badsource and goodsink*/
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                data = cookieSources[0].getValue();
            }
        }

        for (int k = 0; k < 1; k++)
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
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
