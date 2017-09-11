/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__Property_HashMap_31.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashMap
 *    BadSink : Create a HashMap using data as the initial size
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s03;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

import java.util.HashMap;

public class CWE789_Uncontrolled_Mem_Alloc__Property_HashMap_31 extends AbstractTestCase
{
    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        int dataCopy;
        {
            int data;

            data = Integer.MIN_VALUE; /* Initialize data */

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            {
                String stringNumber = System.getProperty("user.home");
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }

            dataCopy = data;
        }
        {
            int data = dataCopy;

            /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
            HashMap intHashMap = new HashMap(data);

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int dataCopy;
        {
            int data;

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

            dataCopy = data;
        }
        {
            int data = dataCopy;

            /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
            HashMap intHashMap = new HashMap(data);

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
