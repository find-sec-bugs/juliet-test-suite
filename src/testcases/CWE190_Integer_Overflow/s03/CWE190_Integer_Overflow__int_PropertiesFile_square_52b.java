/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_PropertiesFile_square_52b.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s03;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_PropertiesFile_square_52b
{
    public void badSink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_PropertiesFile_square_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_PropertiesFile_square_52c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__int_PropertiesFile_square_52c()).goodB2GSink(data );
    }
}
