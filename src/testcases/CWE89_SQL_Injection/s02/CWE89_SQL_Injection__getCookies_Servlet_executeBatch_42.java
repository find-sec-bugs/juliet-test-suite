/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookies_Servlet_executeBatch_42.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: Use prepared statement and executeBatch (properly)
 *    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE89_SQL_Injection.s02;
import testcasesupport.*;

import javax.servlet.http.*;


import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__getCookies_Servlet_executeBatch_42 extends AbstractTestCaseServlet
{
    private String badSource(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        return data;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = badSource(request, response);

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
    private String goodG2BSource(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2BSource(request, response);

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
    private String goodB2GSource(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        return data;
    }

    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodB2GSource(request, response);

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
