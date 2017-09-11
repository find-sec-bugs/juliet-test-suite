/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_rand_sub_03.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: rand Set data to result of rand()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: sub
*    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
*    BadSink : Subtract 1 from data, which can cause an Underflow
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;

public class CWE191_Integer_Underflow__long_rand_sub_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        long data;
        if (5==5)
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (new java.security.SecureRandom()).nextLong();
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (5==5)
        {
            /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
            long result = (long)(data - 1);
            IO.writeLine("result: " + result);
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first 5==5 to 5!=5 */
    private void goodG2B1() throws Throwable
    {
        long data;
        if (5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }

        if (5==5)
        {
            /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
            long result = (long)(data - 1);
            IO.writeLine("result: " + result);
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        long data;
        if (5==5)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (5==5)
        {
            /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
            long result = (long)(data - 1);
            IO.writeLine("result: " + result);
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second 5==5 to 5!=5 */
    private void goodB2G1() throws Throwable
    {
        long data;
        if (5==5)
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (new java.security.SecureRandom()).nextLong();
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Long.MIN_VALUE)
            {
                long result = (long)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        long data;
        if (5==5)
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (new java.security.SecureRandom()).nextLong();
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (5==5)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Long.MIN_VALUE)
            {
                long result = (long)(data - 1);
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
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
