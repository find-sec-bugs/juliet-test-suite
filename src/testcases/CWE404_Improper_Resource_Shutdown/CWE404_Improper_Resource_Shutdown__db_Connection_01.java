/*
 * @description Improper Resource Shutdown.  Performs some, but not all, necessary resource cleanup (DB connection is not closed properly).
 * 
 * */

package testcases.CWE404_Improper_Resource_Shutdown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.security.SecureRandom;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE404_Improper_Resource_Shutdown__db_Connection_01 extends AbstractTestCase 
{
    public void bad()
    {
        ResultSet resultSet = null;
        Connection dBConnection = null;
        PreparedStatement preparedStatement = null;

        try
        {
            int intId = (new SecureRandom()).nextInt(200);

            dBConnection = IO.getDBConnection();
            preparedStatement = dBConnection.prepareStatement("select * from users where id=?");
            preparedStatement.setInt(1, intId);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.first())
            {
                IO.writeString(resultSet.toString());
            }

            /* FLAW: DB objects are not closed properly. They should be in a finally block. */
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
                if (dBConnection != null)
                {
                    dBConnection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }

        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "SQL Error", exceptSql);
        }
    }

    private void good1()
    {
        ResultSet resultSet = null;
        Connection dBConnection = null;
        PreparedStatement preparedStatement = null;

        try
        {
            int intId = (new SecureRandom()).nextInt(200);

            dBConnection = IO.getDBConnection();
            preparedStatement = dBConnection.prepareStatement("select * from users where id=?");
            preparedStatement.setInt(1, intId);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.first())
            {
                IO.writeString(resultSet.toString());
            }
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "SQL Error", exceptSql);
        }
        
        /* FIX: Close DB objects in a finally block */
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
                if (dBConnection != null)
                {
                    dBConnection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }
        }
    }
    
    public void good()  
    {
        good1();
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
