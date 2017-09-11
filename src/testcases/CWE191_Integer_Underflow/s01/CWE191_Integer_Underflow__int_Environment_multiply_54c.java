/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_Environment_multiply_54c.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_Environment_multiply_54c
{
    public void badSink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_Environment_multiply_54d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_Environment_multiply_54d()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_Environment_multiply_54d()).goodB2GSink(data );
    }
}
