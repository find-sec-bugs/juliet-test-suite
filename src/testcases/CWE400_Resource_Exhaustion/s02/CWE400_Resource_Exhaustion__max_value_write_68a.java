/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__max_value_write_68a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: max_value Set count to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE400_Resource_Exhaustion__max_value_write_68a extends AbstractTestCase
{
    public static int count;

    public void bad() throws Throwable
    {

        /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
        count = Integer.MAX_VALUE;

        (new CWE400_Resource_Exhaustion__max_value_write_68b()).badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        (new CWE400_Resource_Exhaustion__max_value_write_68b()).goodG2BSink();
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {

        /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
        count = Integer.MAX_VALUE;

        (new CWE400_Resource_Exhaustion__max_value_write_68b()).goodB2GSink();
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
