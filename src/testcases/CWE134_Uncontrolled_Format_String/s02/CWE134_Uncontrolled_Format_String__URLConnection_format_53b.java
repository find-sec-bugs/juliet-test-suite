/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__URLConnection_format_53b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s02;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__URLConnection_format_53b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__URLConnection_format_53c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__URLConnection_format_53c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__URLConnection_format_53c()).goodB2GSink(data );
    }
}
