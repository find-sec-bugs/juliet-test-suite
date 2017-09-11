/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_listen_tcp_sub_61a.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_listen_tcp_sub_61a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data = (new CWE191_Integer_Underflow__int_listen_tcp_sub_61b()).badSource();

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data = (new CWE191_Integer_Underflow__int_listen_tcp_sub_61b()).goodG2BSource();

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data = (new CWE191_Integer_Underflow__int_listen_tcp_sub_61b()).goodB2GSource();

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Integer.MIN_VALUE)
        {
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to perform subtraction.");
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
