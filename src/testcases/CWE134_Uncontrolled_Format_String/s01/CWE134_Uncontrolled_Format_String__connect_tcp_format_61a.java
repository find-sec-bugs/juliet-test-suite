/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__connect_tcp_format_61a.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__connect_tcp_format_61a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data = (new CWE134_Uncontrolled_Format_String__connect_tcp_format_61b()).badSource();

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data = (new CWE134_Uncontrolled_Format_String__connect_tcp_format_61b()).goodG2BSource();

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data = (new CWE134_Uncontrolled_Format_String__connect_tcp_format_61b()).goodB2GSource();

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.format("%s%n", data);
        }

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
