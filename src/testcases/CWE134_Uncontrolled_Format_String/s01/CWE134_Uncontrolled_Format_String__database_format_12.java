/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__database_format_12.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks: format
*    GoodSink: dynamic formatted stdout with string defined
*    BadSink : dynamic formatted stdout without validation
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;

public class CWE134_Uncontrolled_Format_String__database_format_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;
        if(IO.staticReturnsTrueOrFalse())
        {
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
        }
        else
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else
        {

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
     * both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        String data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else
        {

            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
     * both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;
        if(IO.staticReturnsTrueOrFalse())
        {
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
        }
        else
        {

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

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }
        }
        else
        {

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }

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
