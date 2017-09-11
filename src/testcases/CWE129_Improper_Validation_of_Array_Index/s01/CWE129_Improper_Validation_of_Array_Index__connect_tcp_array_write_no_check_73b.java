/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_write_no_check_73b.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_write_no_check
 *    GoodSink: Write to array after verifying index
 *    BadSink : Write to array without any verification of index
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s01;
import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_write_no_check_73b
{
    public void badSink(LinkedList<Integer> dataLinkedList ) throws Throwable
    {
        int data = dataLinkedList.remove(2);

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
        array[data] = 42;

        /* Skip reading back data from array since that may be another out of bounds operation */

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<Integer> dataLinkedList ) throws Throwable
    {
        int data = dataLinkedList.remove(2);

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
        array[data] = 42;

        /* Skip reading back data from array since that may be another out of bounds operation */

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<Integer> dataLinkedList ) throws Throwable
    {
        int data = dataLinkedList.remove(2);

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* FIX: Verify index before writing to array at location data */
        if (data >= 0 && data < array.length)
        {
            array[data] = 42;
        }
        else
        {
            IO.writeLine("Array index out of bounds");
        }

    }
}
