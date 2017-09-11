/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__random_write_52a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-52a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__random_write_52a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        count = (new SecureRandom()).nextInt();

        (new CWE400_Resource_Exhaustion__random_write_52b()).badSink(count );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        (new CWE400_Resource_Exhaustion__random_write_52b()).goodG2BSink(count );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        count = (new SecureRandom()).nextInt();

        (new CWE400_Resource_Exhaustion__random_write_52b()).goodB2GSink(count );
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
