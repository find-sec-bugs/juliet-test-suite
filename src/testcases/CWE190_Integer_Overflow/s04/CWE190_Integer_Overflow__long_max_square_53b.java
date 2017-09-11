/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_max_square_53b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_max_square_53b
{
    public void badSink(long data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__long_max_square_53c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(long data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__long_max_square_53c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(long data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__long_max_square_53c()).goodB2GSink(data );
    }
}
