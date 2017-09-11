/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_rand_multiply_16.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: rand Set data to result of rand()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: multiply
*    GoodSink: Ensure there will not be an overflow before multiplying data by 2
*    BadSink : If data is positive, multiply by 2, which can cause an overflow
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_rand_multiply_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        byte data;

        while (true)
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE) + Byte.MIN_VALUE);
            break;
        }

        while (true)
        {
            if(data > 0) /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Byte.MAX_VALUE, this will overflow */
                byte result = (byte)(data * 2);
                IO.writeLine("result: " + result);
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        byte data;

        while (true)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
            break;
        }

        while (true)
        {
            if(data > 0) /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Byte.MAX_VALUE, this will overflow */
                byte result = (byte)(data * 2);
                IO.writeLine("result: " + result);
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        byte data;

        while (true)
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE) + Byte.MIN_VALUE);
            break;
        }

        while (true)
        {
            if(data > 0) /* ensure we won't have an underflow */
            {
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data < (Byte.MAX_VALUE/2))
                {
                    byte result = (byte)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too large to perform multiplication.");
                }
            }
            break;
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
