/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__database_printf_42.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;

public class CWE134_Uncontrolled_Format_String__database_printf_42 extends AbstractTestCase
{
    private String badSource() throws Throwable
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

        return data;
    }

    public void bad() throws Throwable
    {
        String data = badSource();

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private String goodG2BSource() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

    private void goodG2B() throws Throwable
    {
        String data = goodG2BSource();

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private String goodB2GSource() throws Throwable
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

        return data;
    }

    private void goodB2G() throws Throwable
    {
        String data = goodB2GSource();

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.printf("%s%n", data);
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
