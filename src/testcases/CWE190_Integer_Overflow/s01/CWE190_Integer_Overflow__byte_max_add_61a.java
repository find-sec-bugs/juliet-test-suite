/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_max_add_61a.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for byte
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_max_add_61a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        byte data = (new CWE190_Integer_Overflow__byte_max_add_61b()).badSource();

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

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
        byte data = (new CWE190_Integer_Overflow__byte_max_add_61b()).goodG2BSource();

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        byte data = (new CWE190_Integer_Overflow__byte_max_add_61b()).goodB2GSource();

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Byte.MAX_VALUE)
        {
            byte result = (byte)(data + 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform addition.");
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
