/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_min_61a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_min
 *    GoodSink: Read from array after verifying that data is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data is at least 0 (but not verifying that data less than array.length)
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_min_61a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data = (new CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_min_61b()).badSource();

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Verify that data >= 0, but don't verify that data < array.length, so may be attempting to read out of the array bounds */
        if (data >= 0)
        {
            IO.writeLine(array[data]);
        }
        else
        {
            IO.writeLine("Array index out of bounds");
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data = (new CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_min_61b()).goodG2BSource();

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Verify that data >= 0, but don't verify that data < array.length, so may be attempting to read out of the array bounds */
        if (data >= 0)
        {
            IO.writeLine(array[data]);
        }
        else
        {
            IO.writeLine("Array index out of bounds");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data = (new CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_min_61b()).goodB2GSource();

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
