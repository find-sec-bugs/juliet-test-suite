/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Property_for_loop_81a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: Property Read count from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__Property_for_loop_81a extends AbstractTestCase
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

        CWE400_Resource_Exhaustion__Property_for_loop_81_base baseObject = new CWE400_Resource_Exhaustion__Property_for_loop_81_bad();
        baseObject.action(count );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        CWE400_Resource_Exhaustion__Property_for_loop_81_base baseObject = new CWE400_Resource_Exhaustion__Property_for_loop_81_goodG2B();
        baseObject.action(count );
    }

    /* goodB2G() - use BadSource and GoodSink */
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

        CWE400_Resource_Exhaustion__Property_for_loop_81_base baseObject = new CWE400_Resource_Exhaustion__Property_for_loop_81_goodB2G();
        baseObject.action(count );
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
