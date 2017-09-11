/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_random_multiply_81_base.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE191_Integer_Underflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE191_Integer_Underflow__int_random_multiply_81_base
{
    public abstract void action(int data ) throws Throwable;
}
