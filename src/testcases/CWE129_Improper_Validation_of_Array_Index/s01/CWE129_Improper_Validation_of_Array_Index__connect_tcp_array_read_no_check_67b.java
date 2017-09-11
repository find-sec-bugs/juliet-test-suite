/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_67b.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_no_check
 *    GoodSink: Read from array after verifying index
 *    BadSink : Read from array without any verification of index
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_67b
{
    public void badSink(CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Attempt to read from array at location data, which may be outside the array bounds */
        IO.writeLine(array[data]);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Attempt to read from array at location data, which may be outside the array bounds */
        IO.writeLine(array[data]);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

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
