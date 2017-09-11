/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_console_readLine_sub_73b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;
import java.util.LinkedList;

public class CWE191_Integer_Underflow__short_console_readLine_sub_73b
{
    public void badSink(LinkedList<Short> dataLinkedList ) throws Throwable
    {
        short data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        short result = (short)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<Short> dataLinkedList ) throws Throwable
    {
        short data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        short result = (short)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<Short> dataLinkedList ) throws Throwable
    {
        short data = dataLinkedList.remove(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Short.MIN_VALUE)
        {
            short result = (short)(data - 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }
}
