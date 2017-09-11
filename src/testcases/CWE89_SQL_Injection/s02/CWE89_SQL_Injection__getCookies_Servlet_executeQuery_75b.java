/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookies_Servlet_executeQuery_75b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-75b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: Use prepared statement and executeQuery (properly)
 *    BadSink : data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s02;
import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.*;

import java.sql.*;


public class CWE89_SQL_Injection__getCookies_Servlet_executeQuery_75b
{
    public void badSink(byte[] dataSerialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* unserialize data */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;

        try
        {
            streamByteArrayInput = new ByteArrayInputStream(dataSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            String data = (String)streamObjectInput.readObject();

            Connection dbConnection = null;
            Statement sqlStatement = null;
            ResultSet resultSet = null;

            try
            {
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.createStatement();

                /* POTENTIAL FLAW: data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection */
                resultSet = sqlStatement.executeQuery("select * from users where name='"+data+"'");

                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(byte[] dataSerialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* unserialize data */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;

        try {
            streamByteArrayInput = new ByteArrayInputStream(dataSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            String data = (String)streamObjectInput.readObject();

            Connection dbConnection = null;
            Statement sqlStatement = null;
            ResultSet resultSet = null;

            try
            {
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.createStatement();

                /* POTENTIAL FLAW: data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection */
                resultSet = sqlStatement.executeQuery("select * from users where name='"+data+"'");

                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(byte[] dataSerialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* unserialize data */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;

        try
        {
            streamByteArrayInput = new ByteArrayInputStream(dataSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            String data = (String)streamObjectInput.readObject();

            Connection dbConnection = null;
            PreparedStatement sqlStatement = null;
            ResultSet resultSet = null;

            try
            {
                /* FIX: Use prepared statement and executeQuery (properly) */
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.prepareStatement("select * from users where name=?");
                sqlStatement.setString(1, data);

                resultSet = sqlStatement.executeQuery();

                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }
}
