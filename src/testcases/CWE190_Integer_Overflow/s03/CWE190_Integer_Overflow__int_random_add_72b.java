/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_random_add_72b.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s03;
import testcasesupport.*;
import java.util.Vector;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_random_add_72b
{
    public void badSink(Vector<Integer> dataVector ) throws Throwable
    {
        int data = dataVector.remove(2);

        /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
        int result = (int)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(Vector<Integer> dataVector ) throws Throwable
    {
        int data = dataVector.remove(2);

        /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
        int result = (int)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(Vector<Integer> dataVector ) throws Throwable
    {
        int data = dataVector.remove(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Integer.MAX_VALUE)
        {
            int result = (int)(data + 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform addition.");
        }

    }
}
