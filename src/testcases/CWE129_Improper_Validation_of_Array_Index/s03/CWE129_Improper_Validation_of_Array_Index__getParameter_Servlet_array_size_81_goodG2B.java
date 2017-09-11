/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_size_81_goodG2B.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_size
 *    GoodSink: data is used to set the size of the array and it must be greater than 0
 *    BadSink : data is used to set the size of the array, but it could be set to 0
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s03;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_size_81_goodG2B extends CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_size_81_base
{
    public void action(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
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
}
