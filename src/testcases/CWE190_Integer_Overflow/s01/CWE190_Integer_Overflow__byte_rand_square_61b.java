/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_rand_square_61b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_rand_square_61b
{
    public byte badSource() throws Throwable
    {
        byte data;

        /* POTENTIAL FLAW: Use a random value */
        data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE) + Byte.MIN_VALUE);

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public byte goodG2BSource() throws Throwable
    {
        byte data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public byte goodB2GSource() throws Throwable
    {
        byte data;

        /* POTENTIAL FLAW: Use a random value */
        data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE) + Byte.MIN_VALUE);

        return data;
    }
}
