/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Property_executeQuery_73a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: Use prepared statement and executeQuery (properly)
 *    BadSink : data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s04;
import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE89_SQL_Injection__Property_executeQuery_73a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        LinkedList<String> dataLinkedList = new LinkedList<String>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE89_SQL_Injection__Property_executeQuery_73b()).badSink(dataLinkedList  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        LinkedList<String> dataLinkedList = new LinkedList<String>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE89_SQL_Injection__Property_executeQuery_73b()).goodG2BSink(dataLinkedList  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        LinkedList<String> dataLinkedList = new LinkedList<String>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE89_SQL_Injection__Property_executeQuery_73b()).goodB2GSink(dataLinkedList  );
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
