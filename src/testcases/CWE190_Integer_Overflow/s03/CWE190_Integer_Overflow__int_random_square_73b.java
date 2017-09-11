/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_random_square_73b.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s03;
import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_random_square_73b
{
    public void badSink(LinkedList<Integer> dataLinkedList ) throws Throwable
    {
        int data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
        int result = (int)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<Integer> dataLinkedList ) throws Throwable
    {
        int data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
        int result = (int)(data * data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<Integer> dataLinkedList ) throws Throwable
    {
        int data = dataLinkedList.remove(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
        if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
        {
            int result = (int)(data * data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform squaring.");
        }

    }
}
