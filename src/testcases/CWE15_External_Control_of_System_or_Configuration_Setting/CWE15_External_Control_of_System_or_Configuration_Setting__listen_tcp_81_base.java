/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE15_External_Control_of_System_or_Configuration_Setting__listen_tcp_81_base.java
Label Definition File: CWE15_External_Control_of_System_or_Configuration_Setting.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 15 External Control of System or Configuration Setting
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Set the catalog name with the value of data
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE15_External_Control_of_System_or_Configuration_Setting;

import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE15_External_Control_of_System_or_Configuration_Setting__listen_tcp_81_base
{
    public abstract void action(String data ) throws Throwable;
}
