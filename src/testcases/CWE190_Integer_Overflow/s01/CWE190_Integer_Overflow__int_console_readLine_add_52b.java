/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_console_readLine_add_52b.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_console_readLine_add_52b
{
    public void badSink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_console_readLine_add_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_console_readLine_add_52c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_console_readLine_add_52c()).goodB2GSink(data );
    }
}
