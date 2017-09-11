/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_console_readLine_add_54d.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_console_readLine_add_54d
{
    public void badSink(short data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__short_console_readLine_add_54e()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(short data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__short_console_readLine_add_54e()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(short data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__short_console_readLine_add_54e()).goodB2GSink(data );
    }
}
