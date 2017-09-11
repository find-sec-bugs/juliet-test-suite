/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__Property_67a.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-67a.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: Property Read data from a system property
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__Property_67a extends AbstractTestCase
{
    static class Container
    {
        public String containerOne;
    }

    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        (new CWE470_Unsafe_Reflection__Property_67b()).badSink(dataContainer  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded class name */
        data = "Testing.test";

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        (new CWE470_Unsafe_Reflection__Property_67b()).goodG2BSink(dataContainer  );
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
