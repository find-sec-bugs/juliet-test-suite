/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__int_Environment_to_byte_73a.java
Label Definition File: CWE197_Numeric_Truncation_Error__int.label.xml
Template File: sources-sink-73a.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s01;
import testcasesupport.*;
import java.util.LinkedList;

import java.util.logging.Level;

public class CWE197_Numeric_Truncation_Error__int_Environment_to_byte_73a extends AbstractTestCase
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

        LinkedList<Integer> dataLinkedList = new LinkedList<Integer>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE197_Numeric_Truncation_Error__int_Environment_to_byte_73b()).badSink(dataLinkedList  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        LinkedList<Integer> dataLinkedList = new LinkedList<Integer>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE197_Numeric_Truncation_Error__int_Environment_to_byte_73b()).goodG2BSink(dataLinkedList  );
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
