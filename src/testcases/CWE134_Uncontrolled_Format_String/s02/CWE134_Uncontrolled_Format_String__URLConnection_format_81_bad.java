/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__URLConnection_format_81_bad.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s02;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__URLConnection_format_81_bad extends CWE134_Uncontrolled_Format_String__URLConnection_format_81_base
{
    public void action(String data ) throws Throwable
    {

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }
}
