/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Environment_format_67b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__Environment_format_67b
{
    public void badSink(CWE134_Uncontrolled_Format_String__Environment_format_67a.Container dataContainer ) throws Throwable
    {
        String data = dataContainer.containerOne;

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE134_Uncontrolled_Format_String__Environment_format_67a.Container dataContainer ) throws Throwable
    {
        String data = dataContainer.containerOne;

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(CWE134_Uncontrolled_Format_String__Environment_format_67a.Container dataContainer ) throws Throwable
    {
        String data = dataContainer.containerOne;

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.format("%s%n", data);
        }

    }
}
