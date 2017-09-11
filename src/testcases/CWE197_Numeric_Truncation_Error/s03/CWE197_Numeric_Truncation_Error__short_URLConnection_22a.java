/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_URLConnection_22a.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-22a.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s03;
import testcasesupport.*;

public class CWE197_Numeric_Truncation_Error__short_URLConnection_22a extends AbstractTestCase
{
    /* The public static variable below is used to drive control flow in the source function.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean badPublicStatic = false;

    public void bad() throws Throwable
    {
        short data;

        badPublicStatic = true;
        data = (new CWE197_Numeric_Truncation_Error__short_URLConnection_22b()).badSource();

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }

    }

    /* The public static variables below are used to drive control flow in the source functions.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodG2B1PublicStatic = false;
    public static boolean goodG2B2PublicStatic = false;

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    private void goodG2B1() throws Throwable
    {
        short data;

        goodG2B1PublicStatic = false;
        data = (new CWE197_Numeric_Truncation_Error__short_URLConnection_22b()).goodG2B1Source();

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }

    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    private void goodG2B2() throws Throwable
    {
        short data;

        goodG2B2PublicStatic = true;
        data = (new CWE197_Numeric_Truncation_Error__short_URLConnection_22b()).goodG2B2Source();

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
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
