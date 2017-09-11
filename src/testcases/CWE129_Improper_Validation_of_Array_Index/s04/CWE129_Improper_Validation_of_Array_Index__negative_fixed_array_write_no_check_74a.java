/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__negative_fixed_array_write_no_check_74a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: negative_fixed Set data to a negative value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_write_no_check
 *    GoodSink: Write to array after verifying index
 *    BadSink : Write to array without any verification of index
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s04;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__negative_fixed_array_write_no_check_74a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a negative value */
        data = -1;

        HashMap<Integer,Integer> dataHashMap = new HashMap<Integer,Integer>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE129_Improper_Validation_of_Array_Index__negative_fixed_array_write_no_check_74b()).badSink(dataHashMap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        HashMap<Integer,Integer> dataHashMap = new HashMap<Integer,Integer>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE129_Improper_Validation_of_Array_Index__negative_fixed_array_write_no_check_74b()).goodG2BSink(dataHashMap  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a negative value */
        data = -1;

        HashMap<Integer,Integer> dataHashMap = new HashMap<Integer,Integer>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE129_Improper_Validation_of_Array_Index__negative_fixed_array_write_no_check_74b()).goodB2GSink(dataHashMap  );
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
