/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_rand_multiply_73b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;
import java.util.LinkedList;

public class CWE191_Integer_Underflow__long_rand_multiply_73b
{
    public void badSink(LinkedList<Long> dataLinkedList ) throws Throwable
    {
        long data = dataLinkedList.remove(2);

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
            long result = (long)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<Long> dataLinkedList ) throws Throwable
    {
        long data = dataLinkedList.remove(2);

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
            long result = (long)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<Long> dataLinkedList ) throws Throwable
    {
        long data = dataLinkedList.remove(2);

        if(data < 0) /* ensure we won't have an overflow */
        {
            /* FIX: Add a check to prevent an underflow from occurring */
            if (data > (Long.MIN_VALUE/2))
            {
                long result = (long)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform multiplication.");
            }
        }

    }
}
