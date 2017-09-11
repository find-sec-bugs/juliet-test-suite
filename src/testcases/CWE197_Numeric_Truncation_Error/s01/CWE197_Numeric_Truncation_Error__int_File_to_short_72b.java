/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__int_File_to_short_72b.java
Label Definition File: CWE197_Numeric_Truncation_Error__int.label.xml
Template File: sources-sink-72b.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_short
 *    BadSink : Convert data to a short
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s01;
import testcasesupport.*;
import java.util.Vector;

public class CWE197_Numeric_Truncation_Error__int_File_to_short_72b
{
    public void badSink(Vector<Integer> dataVector ) throws Throwable
    {
        int data = dataVector.remove(2);

        {
            /* POTENTIAL FLAW: Convert data to a short, possibly causing a truncation error */
            IO.writeLine((short)data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Vector<Integer> dataVector ) throws Throwable
    {
        int data = dataVector.remove(2);

        {
            /* POTENTIAL FLAW: Convert data to a short, possibly causing a truncation error */
            IO.writeLine((short)data);
        }

    }
}
