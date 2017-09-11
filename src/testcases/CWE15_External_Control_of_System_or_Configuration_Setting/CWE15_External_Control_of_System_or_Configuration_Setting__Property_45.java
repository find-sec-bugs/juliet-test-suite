/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE15_External_Control_of_System_or_Configuration_Setting__Property_45.java
Label Definition File: CWE15_External_Control_of_System_or_Configuration_Setting.label.xml
Template File: sources-sink-45.tmpl.java
*/
/*
 * @description
 * CWE: 15 External Control of System or Configuration Setting
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Set the catalog name with the value of data
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE15_External_Control_of_System_or_Configuration_Setting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.*;

import java.util.logging.Level;

public class CWE15_External_Control_of_System_or_Configuration_Setting__Property_45 extends AbstractTestCase
{
    private String dataBad;
    private String dataGoodG2B;

    private void badSink() throws Throwable
    {
        String data = dataBad;

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

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        dataBad = data;
        badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    private void goodG2BSink() throws Throwable
    {
        String data = dataGoodG2B;

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

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        dataGoodG2B = data;
        goodG2BSink();
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
