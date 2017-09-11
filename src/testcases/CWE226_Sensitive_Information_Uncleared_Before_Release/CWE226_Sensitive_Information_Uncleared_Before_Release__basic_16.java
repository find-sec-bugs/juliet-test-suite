/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE226_Sensitive_Information_Uncleared_Before_Release__basic_16.java
Label Definition File: CWE226_Sensitive_Information_Uncleared_Before_Release__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 226 Sensitive Information Uncleared Before Release
* Sinks:
*    GoodSink: Sensitive info (password) is stored in a mutable object, but is zeroized after use
*    BadSink : Sensitive info (password) is stored in a mutable object and is uncleared
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE226_Sensitive_Information_Uncleared_Before_Release;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.logging.Level;

public class CWE226_Sensitive_Information_Uncleared_Before_Release__basic_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;
            StringBuffer password = new StringBuffer();
            Connection dBConnection = null;
            /* read user input from console with readLine */
            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
                password.append(readerBuffered.readLine());
                dBConnection = DriverManager.getConnection("192.168.105.23", "sa", password.toString());
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
                /* FLAW: the password is stored in a mutable object (StringBuffer) and it is not cleared */

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

                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }
            }
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;
            StringBuffer password = new StringBuffer();
            Connection dBConnection = null;
            /* read user input from console with readLine */
            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
                password.append(readerBuffered.readLine());
                dBConnection = DriverManager.getConnection("192.168.105.23", "sa", password.toString());
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
                /* FIX: Zeroize the password */
                password.delete(0, password.length());

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

                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }
            }
            break;
        }
    }

    public void good() throws Throwable
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
