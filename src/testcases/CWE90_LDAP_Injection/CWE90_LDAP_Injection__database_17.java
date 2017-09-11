/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__database_17.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 90 LDAP Injection
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* BadSink:  data concatenated into LDAP search, which could result in LDAP Injection
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;

import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

public class CWE90_LDAP_Injection__database_17 extends AbstractTestCase
{
    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;

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

        for (int i = 0; i < 1; i++)
        {
            Hashtable<String, String> environmentHashTable = new Hashtable<String, String>();
            environmentHashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
            environmentHashTable.put(Context.PROVIDER_URL, "ldap://localhost:389");
            DirContext directoryContext = null;
            try
            {
                directoryContext = new InitialDirContext(environmentHashTable);
                /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
                String search = "(cn=" + data + ")";
                NamingEnumeration<SearchResult> answer = directoryContext.search("", search, null);
                while (answer.hasMore())
                {
                    SearchResult searchResult = answer.next();
                    Attributes attributes = searchResult.getAttributes();
                    NamingEnumeration<?> allAttributes = attributes.getAll();
                    while (allAttributes.hasMore())
                    {
                        Attribute attribute = (Attribute) allAttributes.next();
                        NamingEnumeration<?> allValues = attribute.getAll();
                        while(allValues.hasMore())
                        {
                            IO.writeLine(" Value: " + allValues.next().toString());
                        }
                    }
                }
            }
            catch (NamingException exceptNaming)
            {
                IO.logger.log(Level.WARNING, "The LDAP service was not found or login failed.", exceptNaming);
            }
            finally
            {
                if (directoryContext != null)
                {
                    try
                    {
                        directoryContext.close();
                    }
                    catch (NamingException exceptNaming)
                    {
                        IO.logger.log(Level.WARNING, "Error closing DirContext", exceptNaming);
                    }
                }
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
     * for statement with the one in the for statement */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        for (int i = 0; i < 1; i++)
        {
            Hashtable<String, String> environmentHashTable = new Hashtable<String, String>();
            environmentHashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
            environmentHashTable.put(Context.PROVIDER_URL, "ldap://localhost:389");
            DirContext directoryContext = null;
            try
            {
                directoryContext = new InitialDirContext(environmentHashTable);
                /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
                String search = "(cn=" + data + ")";
                NamingEnumeration<SearchResult> answer = directoryContext.search("", search, null);
                while (answer.hasMore())
                {
                    SearchResult searchResult = answer.next();
                    Attributes attributes = searchResult.getAttributes();
                    NamingEnumeration<?> allAttributes = attributes.getAll();
                    while (allAttributes.hasMore())
                    {
                        Attribute attribute = (Attribute) allAttributes.next();
                        NamingEnumeration<?> allValues = attribute.getAll();
                        while(allValues.hasMore())
                        {
                            IO.writeLine(" Value: " + allValues.next().toString());
                        }
                    }
                }
            }
            catch (NamingException exceptNaming)
            {
                IO.logger.log(Level.WARNING, "The LDAP service was not found or login failed.", exceptNaming);
            }
            finally
            {
                if (directoryContext != null)
                {
                    try
                    {
                        directoryContext.close();
                    }
                    catch (NamingException exceptNaming)
                    {
                        IO.logger.log(Level.WARNING, "Error closing DirContext", exceptNaming);
                    }
                }
            }
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
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
