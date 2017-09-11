/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_listen_tcp_53b.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: listen_tcp Read count using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_listen_tcp_53b
{
    public void badSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__sleep_listen_tcp_53c()).badSink(count );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__sleep_listen_tcp_53c()).goodG2BSink(count );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__sleep_listen_tcp_53c()).goodB2GSink(count );
    }
}
