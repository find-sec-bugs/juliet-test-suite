/*
 * @description An object contains sensitive data and is implicitly serializable
 *  
 * This class contains the "good" version, which prohibits serialization by
 * overriding the function writeObject.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import testcasesupport.*;


public class CWE499_Sensitive_Data_Serializable__serializable_01_good1 extends CWE499_Sensitive_Data_Serializable__serializable_Helper 
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

    /* FIX: Override writeObject(), readObject(),  and readObjectNoData() methods to deny serialization attempts */
    private final void writeObject(ObjectOutputStream out) throws IOException
    {
        throw new NotSerializableException();
    }
    
    private final void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        throw new NotSerializableException();
    }
	
	private final void readObjectNoData() throws ObjectStreamException
	{
        throw new NotSerializableException();
    }
}
