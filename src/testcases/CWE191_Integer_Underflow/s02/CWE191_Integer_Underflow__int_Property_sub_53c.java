/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_Property_sub_53c.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_Property_sub_53c
{
    public void badSink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_Property_sub_53d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_Property_sub_53d()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_Property_sub_53d()).goodB2GSink(data );
    }
}
