/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__File_array_read_check_max_68b.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_max
 *    GoodSink: Read from array after verifying index is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data less than array.length (but not verifying that data is at least 0)
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__File_array_read_check_max_68b
{
    public void badSink() throws Throwable
    {
        int data = CWE129_Improper_Validation_of_Array_Index__File_array_read_check_max_68a.data;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Verify that data < array.length, but don't verify that data > 0, so may be attempting to read out of the array bounds */
        if (data < array.length)
        {
            IO.writeLine(array[data]);
        }
        else
        {
            IO.writeLine("Array index out of bounds");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        int data = CWE129_Improper_Validation_of_Array_Index__File_array_read_check_max_68a.data;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Verify that data < array.length, but don't verify that data > 0, so may be attempting to read out of the array bounds */
        if (data < array.length)
        {
            IO.writeLine(array[data]);
        }
        else
        {
            IO.writeLine("Array index out of bounds");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        int data = CWE129_Improper_Validation_of_Array_Index__File_array_read_check_max_68a.data;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* FIX: Fully verify data before reading from array at location data */
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
