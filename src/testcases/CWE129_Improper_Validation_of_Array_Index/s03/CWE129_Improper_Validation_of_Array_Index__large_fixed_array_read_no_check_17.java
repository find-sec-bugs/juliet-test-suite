/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__large_fixed_array_read_no_check_17.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 129 Improper Validation of Array Index
* BadSource: large_fixed Set data to a value greater than the size of the array
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: array_read_no_check
*    GoodSink: Read from array after verifying index
*    BadSink : Read from array without any verification of index
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE129_Improper_Validation_of_Array_Index.s03;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__large_fixed_array_read_no_check_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        /* We need to have one source outside of a for loop in order
         * to prevent the Java compiler from generating an error because
         * data is uninitialized
         */

        /* POTENTIAL FLAW: Set data to a value greater than the size of the array */
        data = 100;

        for (int j = 0; j < 1; j++)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to read from array at location data, which may be outside the array bounds */
            IO.writeLine(array[data]);
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        for (int j = 0; j < 1; j++)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to read from array at location data, which may be outside the array bounds */
            IO.writeLine(array[data]);
        }
    }

    /* goodB2G() - use badsource and goodsink*/
    private void goodB2G() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a value greater than the size of the array */
        data = 100;

        for (int k = 0; k < 1; k++)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* FIX: Verify index before reading from array at location data */
            if (data >= 0 && data < array.length)
            {
                IO.writeLine(array[data]);
            }
            else
            {
                IO.writeLine("Array index out of bounds");
            }
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
