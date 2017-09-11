/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__Environment_72a.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;
import java.util.Vector;

import javax.servlet.http.*;

public class CWE643_Xpath_Injection__Environment_72a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE643_Xpath_Injection__Environment_72b()).badSink(dataVector  );
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
        (new CWE643_Xpath_Injection__Environment_72b()).goodG2BSink(dataVector  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE643_Xpath_Injection__Environment_72b()).goodB2GSink(dataVector  );
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
