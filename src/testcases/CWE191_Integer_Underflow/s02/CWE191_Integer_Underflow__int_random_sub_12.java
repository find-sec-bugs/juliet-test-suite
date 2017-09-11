/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_random_sub_12.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: random Set data to a random value
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: sub
*    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
*    BadSink : Subtract 1 from data, which can cause an Underflow
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE191_Integer_Underflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__int_random_sub_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Set data to a random value */
            data = (new SecureRandom()).nextInt();
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        else
        {

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
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
     * both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        int data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        else
        {

            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);

            IO.writeLine("result: " + result);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
     * both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        int data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Set data to a random value */
            data = (new SecureRandom()).nextInt();
        }
        else
        {

            /* POTENTIAL FLAW: Set data to a random value */
            data = (new SecureRandom()).nextInt();

        }

        if(IO.staticReturnsTrueOrFalse())
        {
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
        else
        {

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
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
