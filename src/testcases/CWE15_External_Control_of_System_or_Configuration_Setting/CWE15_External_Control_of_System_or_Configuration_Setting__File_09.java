/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE15_External_Control_of_System_or_Configuration_Setting__File_09.java
Label Definition File: CWE15_External_Control_of_System_or_Configuration_Setting.label.xml
Template File: sources-sink-09.tmpl.java
*/
/*
* @description
* CWE: 15 External Control of System or Configuration Setting
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* BadSink:  Set the catalog name with the value of data
* Flow Variant: 09 Control flow: if(IO.STATIC_FINAL_TRUE) and if(IO.STATIC_FINAL_FALSE)
*
* */

package testcases.CWE15_External_Control_of_System_or_Configuration_Setting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

import java.sql.*;


public class CWE15_External_Control_of_System_or_Configuration_Setting__File_09 extends AbstractTestCase
{
    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
        {
            data = ""; /* Initialize data */
            {
                File file = new File("C:\\data.txt");
                FileInputStream streamFileInput = null;
                InputStreamReader readerInputStream = null;
                BufferedReader readerBuffered = null;
                try
                {
                    /* read string from file into data */
                    streamFileInput = new FileInputStream(file);
                    readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    /* POTENTIAL FLAW: Read data from a file */
                    /* This will be reading the first "line" of the file, which
                     * could be very long if there are little or no newlines in the file */
                    data = readerBuffered.readLine();
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Close stream reading objects */
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

                    try
                    {
                        if (streamFileInput != null)
                        {
                            streamFileInput.close();
                        }
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
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

        Connection dbConnection = null;

        try
        {
            dbConnection = IO.getDBConnection();

            /* POTENTIAL FLAW: Set the catalog name with the value of data
             * allowing a nonexistent catalog name or unauthorized access to a portion of the DB */
            dbConnection.setCatalog(data);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
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

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        Connection dbConnection = null;

        try
        {
            dbConnection = IO.getDBConnection();

            /* POTENTIAL FLAW: Set the catalog name with the value of data
             * allowing a nonexistent catalog name or unauthorized access to a portion of the DB */
            dbConnection.setCatalog(data);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
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

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if (IO.STATIC_FINAL_TRUE)
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

        Connection dbConnection = null;

        try
        {
            dbConnection = IO.getDBConnection();

            /* POTENTIAL FLAW: Set the catalog name with the value of data
             * allowing a nonexistent catalog name or unauthorized access to a portion of the DB */
            dbConnection.setCatalog(data);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
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
