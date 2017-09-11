/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_square_53c.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_console_readLine_square_53c
{
    public void badSink(byte data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__byte_console_readLine_square_53d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(byte data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__byte_console_readLine_square_53d()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(byte data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__byte_console_readLine_square_53d()).goodB2GSink(data );
    }
}
