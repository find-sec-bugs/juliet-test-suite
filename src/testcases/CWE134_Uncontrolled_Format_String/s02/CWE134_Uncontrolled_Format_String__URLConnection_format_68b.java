/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__URLConnection_format_68b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s02;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__URLConnection_format_68b
{
    public void badSink() throws Throwable
    {
        String data = CWE134_Uncontrolled_Format_String__URLConnection_format_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        String data = CWE134_Uncontrolled_Format_String__URLConnection_format_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        String data = CWE134_Uncontrolled_Format_String__URLConnection_format_68a.data;

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.format("%s%n", data);
        }

    }
}
