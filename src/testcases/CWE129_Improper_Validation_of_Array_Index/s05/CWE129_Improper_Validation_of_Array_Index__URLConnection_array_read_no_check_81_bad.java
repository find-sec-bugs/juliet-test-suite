/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__URLConnection_array_read_no_check_81_bad.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_no_check
 *    GoodSink: Read from array after verifying index
 *    BadSink : Read from array without any verification of index
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s05;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__URLConnection_array_read_no_check_81_bad extends CWE129_Improper_Validation_of_Array_Index__URLConnection_array_read_no_check_81_base
{
    public void action(int data ) throws Throwable
    {

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Attempt to read from array at location data, which may be outside the array bounds */
        IO.writeLine(array[data]);

    }
}
