/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_Property_61b.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-61b.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE197_Numeric_Truncation_Error.s02;
import testcasesupport.*;

import java.util.logging.Level;

public class CWE197_Numeric_Truncation_Error__short_Property_61b
{
    public short badSource() throws Throwable
    {
        short data;

        data = Short.MIN_VALUE; /* Initialize data */

        /* get system property user.home */
        /* FLAW: Read data from a system property */
        {
            String stringNumber = System.getProperty("user.home");
            try
            {
                data = Short.parseShort(stringNumber.trim());
            }
            catch(NumberFormatException exceptNumberFormat)
            {
                IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
            }
        }

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public short goodG2BSource() throws Throwable
    {
        short data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }
}
