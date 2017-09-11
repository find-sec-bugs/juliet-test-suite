/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Environment_format_45.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__Environment_format_45 extends AbstractTestCase
{
    private String dataBad;
    private String dataGoodG2B;
    private String dataGoodB2G;

    private void badSink() throws Throwable
    {
        String data = dataBad;

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        dataBad = data;
        badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink() throws Throwable
    {
        String data = dataGoodG2B;

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
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

    private void goodB2GSink() throws Throwable
    {
        String data = dataGoodB2G;

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.format("%s%n", data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        dataGoodB2G = data;
        goodB2GSink();
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
