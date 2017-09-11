/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Property_printf_31.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__Property_printf_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String dataCopy;
        {
            String data;

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");

            dataCopy = data;
        }
        {
            String data = dataCopy;

            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }

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
        String dataCopy;
        {
            String data;

            /* FIX: Use a hardcoded string */
            data = "foo";

            dataCopy = data;
        }
        {
            String data = dataCopy;

            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String dataCopy;
        {
            String data;

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");

            dataCopy = data;
        }
        {
            String data = dataCopy;

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
            }

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
