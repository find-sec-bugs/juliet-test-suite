/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_console_readLine_multiply_81_base.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

public abstract class CWE191_Integer_Underflow__byte_console_readLine_multiply_81_base
{
    public abstract void action(byte data ) throws Throwable;
}
