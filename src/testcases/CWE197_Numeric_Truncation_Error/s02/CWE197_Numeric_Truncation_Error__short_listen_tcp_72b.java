/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_listen_tcp_72b.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-72b.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s02;
import testcasesupport.*;
import java.util.Vector;

public class CWE197_Numeric_Truncation_Error__short_listen_tcp_72b
{
    public void badSink(Vector<Short> dataVector ) throws Throwable
    {
        short data = dataVector.remove(2);

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Vector<Short> dataVector ) throws Throwable
    {
        short data = dataVector.remove(2);

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }

    }
}
