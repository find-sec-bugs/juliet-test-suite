/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__database_09.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-09.tmpl.java
*/
/*
* @description
* CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
* BadSource: database Read data from a database
* GoodSource: Set data to a hardcoded class name
* BadSink:  Instantiate class named in data
* Flow Variant: 09 Control flow: if(IO.STATIC_FINAL_TRUE) and if(IO.STATIC_FINAL_FALSE)
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;

public class CWE470_Unsafe_Reflection__database_09 extends AbstractTestCase
{
    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
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

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    /* goodG2B1() - use goodsource and badsink by changing IO.STATIC_FINAL_TRUE to IO.STATIC_FINAL_FALSE */
    private void goodG2B1() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_FALSE)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
        {
            /* FIX: Use a hardcoded class name */
            data = "Testing.test";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
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
