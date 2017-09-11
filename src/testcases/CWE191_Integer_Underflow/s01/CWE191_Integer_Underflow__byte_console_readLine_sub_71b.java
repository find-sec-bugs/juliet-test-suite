/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_console_readLine_sub_71b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-71b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_console_readLine_sub_71b
{
    public void badSink(Object dataObject ) throws Throwable
    {
        byte data = (Byte)dataObject;

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        byte result = (byte)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Object dataObject ) throws Throwable
    {
        byte data = (Byte)dataObject;

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        byte result = (byte)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(Object dataObject ) throws Throwable
    {
        byte data = (Byte)dataObject;

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Byte.MIN_VALUE)
        {
            byte result = (byte)(data - 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }
}
