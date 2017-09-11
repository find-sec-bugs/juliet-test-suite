/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_random_multiply_81a.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE191_Integer_Underflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__int_random_multiply_81a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a random value */
        data = (new SecureRandom()).nextInt();

        CWE191_Integer_Underflow__int_random_multiply_81_base baseObject = new CWE191_Integer_Underflow__int_random_multiply_81_bad();
        baseObject.action(data );
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

        CWE191_Integer_Underflow__int_random_multiply_81_base baseObject = new CWE191_Integer_Underflow__int_random_multiply_81_goodG2B();
        baseObject.action(data );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a random value */
        data = (new SecureRandom()).nextInt();

        CWE191_Integer_Underflow__int_random_multiply_81_base baseObject = new CWE191_Integer_Underflow__int_random_multiply_81_goodB2G();
        baseObject.action(data );
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
