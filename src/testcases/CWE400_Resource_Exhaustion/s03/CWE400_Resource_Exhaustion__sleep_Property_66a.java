/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_Property_66a.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: Property Read count from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__sleep_Property_66a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* get system property user.home */
        /* POTENTIAL FLAW: Read count from a system property */
        {
            String stringNumber = System.getProperty("user.home");
            try
            {
                count = Integer.parseInt(stringNumber.trim());
            }
            catch(NumberFormatException exceptNumberFormat)
            {
                IO.logger.log(Level.WARNING, "Number format exception parsing count from string", exceptNumberFormat);
            }
        }

        int[] countArray = new int[5];
        countArray[2] = count;
        (new CWE400_Resource_Exhaustion__sleep_Property_66b()).badSink(countArray  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        int[] countArray = new int[5];
        countArray[2] = count;
        (new CWE400_Resource_Exhaustion__sleep_Property_66b()).goodG2BSink(countArray  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* get system property user.home */
        /* POTENTIAL FLAW: Read count from a system property */
        {
            String stringNumber = System.getProperty("user.home");
            try
            {
                count = Integer.parseInt(stringNumber.trim());
            }
            catch(NumberFormatException exceptNumberFormat)
            {
                IO.logger.log(Level.WARNING, "Number format exception parsing count from string", exceptNumberFormat);
            }
        }

        int[] countArray = new int[5];
        countArray[2] = count;
        (new CWE400_Resource_Exhaustion__sleep_Property_66b()).goodB2GSink(countArray  );
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
