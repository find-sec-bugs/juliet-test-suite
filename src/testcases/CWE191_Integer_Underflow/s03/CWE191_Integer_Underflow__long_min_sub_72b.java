/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_min_sub_72b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;
import java.util.Vector;

public class CWE191_Integer_Underflow__long_min_sub_72b
{
    public void badSink(Vector<Long> dataVector ) throws Throwable
    {
        long data = dataVector.remove(2);

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        long result = (long)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(Vector<Long> dataVector ) throws Throwable
    {
        long data = dataVector.remove(2);

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        long result = (long)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(Vector<Long> dataVector ) throws Throwable
    {
        long data = dataVector.remove(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Long.MIN_VALUE)
        {
            long result = (long)(data - 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }
}
