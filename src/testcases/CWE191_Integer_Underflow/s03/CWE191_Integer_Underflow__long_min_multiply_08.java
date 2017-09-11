/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_min_multiply_08.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-08.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: min Set data to the max value for long
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: multiply
*    GoodSink: Ensure there will not be an underflow before multiplying data by 2
*    BadSink : If data is negative, multiply by 2, which can cause an underflow
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;

public class CWE191_Integer_Underflow__long_min_multiply_08 extends AbstractTestCase
{
    /* The methods below always return the same value, so a tool
     * should be able to figure out that every call to these
     * methods will return true or return false. */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        long data;
        if (privateReturnsTrue())
        {
            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Long.MIN_VALUE;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (privateReturnsTrue())
        {
            if(data < 0) /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
                long result = (long)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first privateReturnsTrue() to privateReturnsFalse() */
    private void goodG2B1() throws Throwable
    {
        long data;
        if (privateReturnsFalse())
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

        if (privateReturnsTrue())
        {
            if(data < 0) /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
                long result = (long)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        long data;
        if (privateReturnsTrue())
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

        if (privateReturnsTrue())
        {
            if(data < 0) /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Long.MIN_VALUE, this will underflow */
                long result = (long)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second privateReturnsTrue() to privateReturnsFalse() */
    private void goodB2G1() throws Throwable
    {
        long data;
        if (privateReturnsTrue())
        {
            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Long.MIN_VALUE;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (privateReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            if(data < 0) /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Long.MIN_VALUE/2))
                {
                    long result = (long)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        long data;
        if (privateReturnsTrue())
        {
            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Long.MIN_VALUE;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }

        if (privateReturnsTrue())
        {
            if(data < 0) /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Long.MIN_VALUE/2))
                {
                    long result = (long)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
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
