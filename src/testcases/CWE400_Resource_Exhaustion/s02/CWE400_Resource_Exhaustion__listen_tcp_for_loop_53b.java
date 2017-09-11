/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__listen_tcp_for_loop_53b.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: listen_tcp Read count using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE400_Resource_Exhaustion__listen_tcp_for_loop_53b
{
    public void badSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__listen_tcp_for_loop_53c()).badSink(count );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__listen_tcp_for_loop_53c()).goodG2BSink(count );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__listen_tcp_for_loop_53c()).goodB2GSink(count );
    }
}
