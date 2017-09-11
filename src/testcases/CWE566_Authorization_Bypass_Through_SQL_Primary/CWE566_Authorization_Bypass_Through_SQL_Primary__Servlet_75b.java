/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_75b.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-75b.tmpl.java
*/
/*
 * @description
 * CWE: 566 Authorization Bypass through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    BadSink : user authorization not checked
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.*;

import java.sql.*;


public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_75b
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

            Connection dBConnection = IO.getDBConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch ( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                preparedStatement = dBConnection.prepareStatement("select * from invoices where uid=?");
                preparedStatement.setInt(1, id);

                resultSet = preparedStatement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error executing query", exceptSql);
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
                    IO.logger.log(Level.WARNING, "Could not close ResultSet", exceptSql);
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
                    IO.logger.log(Level.WARNING, "Could not close PreparedStatement", exceptSql);
                }

                try
                {
                    if (dBConnection != null)
                    {
                        dBConnection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Could not close Connection", exceptSql);
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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(byte[] dataSerialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* unserialize data */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;

        try
        {
            streamByteArrayInput = new ByteArrayInputStream(dataSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            String data = (String)streamObjectInput.readObject();

            Connection dBConnection = IO.getDBConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch ( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                preparedStatement = dBConnection.prepareStatement("select * from invoices where uid=?");
                preparedStatement.setInt(1, id);

                resultSet = preparedStatement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error executing query", exceptSql);
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
                    IO.logger.log(Level.WARNING, "Could not close ResultSet", exceptSql);
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
                    IO.logger.log(Level.WARNING, "Could not close PreparedStatement", exceptSql);
                }

                try
                {
                    if (dBConnection != null)
                    {
                        dBConnection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Could not close Connection", exceptSql);
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
