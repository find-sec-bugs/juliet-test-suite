/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_URLConnection_61a.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: URLConnection Read count from a web server with URLConnection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_URLConnection_61a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count = (new CWE400_Resource_Exhaustion__sleep_URLConnection_61b()).badSource();

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int count = (new CWE400_Resource_Exhaustion__sleep_URLConnection_61b()).goodG2BSource();

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int count = (new CWE400_Resource_Exhaustion__sleep_URLConnection_61b()).goodB2GSource();

        /* FIX: Validate count before using it in a call to Thread.sleep() */
        if (count > 0 && count <= 2000)
        {
            Thread.sleep(count);
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
