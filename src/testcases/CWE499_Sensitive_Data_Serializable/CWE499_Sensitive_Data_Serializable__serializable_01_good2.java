/*
 * @description An object contains sensitive data but does not explicitly
 * prohibit serialization, allowing it to be serialized through another class
 *  
 * This class contains the "good" version, which prohibits serialization by
 * declaring the sensitive variable as transient.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import testcasesupport.*;

/* We would never expect to see a real class like this, but our implementation tries to ensure the fact
 * that one of the fields is sensitive */
public class CWE499_Sensitive_Data_Serializable__serializable_01_good2 extends CWE499_Sensitive_Data_Serializable__serializable_Helper
{
    /* FIX: Use the transient keyword to deny serialization */
    /* Sensitive field */
    private transient String passwordHash;
    
    protected void setPassword(String password)
    {
        passwordHash = password;
    }
    
    protected String getPassword()
    {
        return passwordHash;
    }

    protected void withdraw(float amount) throws SQLException 
    {
        if (passwordHash != null)
        {
            Connection connection = DriverManager.getConnection("192.168.39.10", "sa", passwordHash);
        
            /* etc */
        
            /* close connection */
            if (connection != null)
            {
                try
                {    
                    connection.close();
                } 
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }
        } 
        else 
        {
            IO.logger.log(Level.WARNING, "Invalid password.");
        }
    }
}
