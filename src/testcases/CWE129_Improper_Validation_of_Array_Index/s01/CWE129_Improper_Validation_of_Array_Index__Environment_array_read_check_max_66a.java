/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__Environment_array_read_check_max_66a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_max
 *    GoodSink: Read from array after verifying index is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data less than array.length (but not verifying that data is at least 0)
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

public class CWE129_Improper_Validation_of_Array_Index__Environment_array_read_check_max_66a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        {
            String stringNumber = System.getenv("ADD");
            if (stringNumber != null) // avoid NPD incidental warnings
            {
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }
        }

        int[] dataArray = new int[5];
        dataArray[2] = data;
        (new CWE129_Improper_Validation_of_Array_Index__Environment_array_read_check_max_66b()).badSink(dataArray  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        int[] dataArray = new int[5];
        dataArray[2] = data;
        (new CWE129_Improper_Validation_of_Array_Index__Environment_array_read_check_max_66b()).goodG2BSink(dataArray  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        {
            String stringNumber = System.getenv("ADD");
            if (stringNumber != null) // avoid NPD incidental warnings
            {
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }
        }

        int[] dataArray = new int[5];
        dataArray[2] = data;
        (new CWE129_Improper_Validation_of_Array_Index__Environment_array_read_check_max_66b()).goodB2GSink(dataArray  );
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
