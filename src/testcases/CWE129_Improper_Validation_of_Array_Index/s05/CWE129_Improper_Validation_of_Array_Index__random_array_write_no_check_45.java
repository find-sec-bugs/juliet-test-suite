/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__random_array_write_no_check_45.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_write_no_check
 *    GoodSink: Write to array after verifying index
 *    BadSink : Write to array without any verification of index
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s05;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE129_Improper_Validation_of_Array_Index__random_array_write_no_check_45 extends AbstractTestCase
{
    private int dataBad;
    private int dataGoodG2B;
    private int dataGoodB2G;

    private void badSink() throws Throwable
    {
        int data = dataBad;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
        array[data] = 42;

        /* Skip reading back data from array since that may be another out of bounds operation */

    }

    public void bad() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a random value */
        data = (new SecureRandom()).nextInt();

        dataBad = data;
        badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink() throws Throwable
    {
        int data = dataGoodG2B;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
        array[data] = 42;

        /* Skip reading back data from array since that may be another out of bounds operation */

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        dataGoodG2B = data;
        goodG2BSink();
    }

    private void goodB2GSink() throws Throwable
    {
        int data = dataGoodB2G;

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a random value */
        data = (new SecureRandom()).nextInt();

        dataGoodB2G = data;
        goodB2GSink();
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
