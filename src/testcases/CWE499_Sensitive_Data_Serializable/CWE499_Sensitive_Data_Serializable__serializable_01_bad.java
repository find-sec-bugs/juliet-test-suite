/*
 * @description An object contains sensitive data and is serializable
 *  
 * This class contains the "bad" version, which does not explicitly deny serialization.  
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import testcasesupport.*;

 
/* FLAW: Class extends a serializable class, does not explicitly deny serialization, and contains sensitive data. */ 
public class CWE499_Sensitive_Data_Serializable__serializable_01_bad extends CWE499_Sensitive_Data_Serializable__serializable_Helper
{    
    /* Sensitive field */
    private String passwordHash;
    
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
