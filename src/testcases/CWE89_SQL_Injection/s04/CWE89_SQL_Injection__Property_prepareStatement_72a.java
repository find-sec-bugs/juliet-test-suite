/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Property_prepareStatement_72a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: prepareStatement
 *    GoodSink: Use prepared statement and execute (properly)
 *    BadSink : data concatenated into SQL statement used in prepareStatement() call, which could result in SQL Injection
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s04;
import testcasesupport.*;
import java.util.Vector;

import javax.servlet.http.*;

public class CWE89_SQL_Injection__Property_prepareStatement_72a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE89_SQL_Injection__Property_prepareStatement_72b()).badSink(dataVector  );
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

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE89_SQL_Injection__Property_prepareStatement_72b()).goodG2BSink(dataVector  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE89_SQL_Injection__Property_prepareStatement_72b()).goodB2GSink(dataVector  );
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
