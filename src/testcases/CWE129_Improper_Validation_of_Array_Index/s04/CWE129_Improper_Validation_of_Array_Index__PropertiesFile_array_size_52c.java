/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_size_52c.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_size
 *    GoodSink: data is used to set the size of the array and it must be greater than 0
 *    BadSink : data is used to set the size of the array, but it could be set to 0
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_size_52c
{
    public void badSink(int data ) throws Throwable
    {

        int array[] = null;

        /* POTENTIAL FLAW: Verify that data is non-negative, but still allow it to be 0 */
        if (data >= 0)
        {
            array = new int[data];
        }
        else
        {
            IO.writeLine("Array size is negative");
        }

        /* do something with the array */
        array[0] = 5;
        IO.writeLine(array[0]);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data ) throws Throwable
    {

        int array[] = null;

        /* POTENTIAL FLAW: Verify that data is non-negative, but still allow it to be 0 */
        if (data >= 0)
        {
            array = new int[data];
        }
        else
        {
            IO.writeLine("Array size is negative");
        }

        /* do something with the array */
        array[0] = 5;
        IO.writeLine(array[0]);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int data ) throws Throwable
    {

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = null;

        /* FIX: Verify that data is non-negative AND greater than 0 */
        if (data > 0)
        {
            array = new int[data];
        }
        else
        {
            IO.writeLine("Array size is negative");
        }

        /* do something with the array */
        array[0] = 5;
        IO.writeLine(array[0]);

    }
}
