/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_database_sub_81_goodG2B.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_database_sub_81_goodG2B extends CWE191_Integer_Underflow__int_database_sub_81_base
{
    public void action(int data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }
}
