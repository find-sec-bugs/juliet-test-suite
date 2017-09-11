/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_console_readLine_sub_66b.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_console_readLine_sub_66b
{
    public void badSink(int dataArray[] ) throws Throwable
    {
        int data = dataArray[2];

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int dataArray[] ) throws Throwable
    {
        int data = dataArray[2];

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int dataArray[] ) throws Throwable
    {
        int data = dataArray[2];

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Integer.MIN_VALUE)
        {
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }
}
