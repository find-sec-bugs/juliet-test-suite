/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__database_printf_14.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-14.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks: printf
*    GoodSink: dynamic printf format with string defined
*    BadSink : dynamic printf without validation
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;

public class CWE134_Uncontrolled_Format_String__database_printf_14 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.staticFive==5 to IO.staticFive!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        if (IO.staticFive!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        if (IO.staticFive==5)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.staticFive==5 to IO.staticFive!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
            }
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
