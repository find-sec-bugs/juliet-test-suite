/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_add_68b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_console_readLine_add_68b
{
    public void badSink() throws Throwable
    {
        byte data = CWE190_Integer_Overflow__byte_console_readLine_add_68a.data;

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        byte data = CWE190_Integer_Overflow__byte_console_readLine_add_68a.data;

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        byte data = CWE190_Integer_Overflow__byte_console_readLine_add_68a.data;

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
}
