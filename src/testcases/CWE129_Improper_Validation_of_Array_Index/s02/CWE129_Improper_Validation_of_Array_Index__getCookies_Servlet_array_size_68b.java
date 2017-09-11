/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_size_68b.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_size
 *    GoodSink: data is used to set the size of the array and it must be greater than 0
 *    BadSink : data is used to set the size of the array, but it could be set to 0
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_size_68b
{
    public void badSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_size_68a.data;

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
    public void goodG2BSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_size_68a.data;

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
    public void goodB2GSink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_size_68a.data;

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
