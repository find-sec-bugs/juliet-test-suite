/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE15_External_Control_of_System_or_Configuration_Setting__Environment_54d.java
Label Definition File: CWE15_External_Control_of_System_or_Configuration_Setting.label.xml
Template File: sources-sink-54d.tmpl.java
*/
/*
 * @description
 * CWE: 15 External Control of System or Configuration Setting
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Set the catalog name with the value of data
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE15_External_Control_of_System_or_Configuration_Setting;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE15_External_Control_of_System_or_Configuration_Setting__Environment_54d
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE15_External_Control_of_System_or_Configuration_Setting__Environment_54e()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE15_External_Control_of_System_or_Configuration_Setting__Environment_54e()).goodG2BSink(data );
    }
}
