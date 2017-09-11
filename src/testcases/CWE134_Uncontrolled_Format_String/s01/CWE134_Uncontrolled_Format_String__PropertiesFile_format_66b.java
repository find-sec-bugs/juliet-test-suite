/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__PropertiesFile_format_66b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__PropertiesFile_format_66b
{
    public void badSink(String dataArray[] ) throws Throwable
    {
        String data = dataArray[2];

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String dataArray[] ) throws Throwable
    {
        String data = dataArray[2];

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String dataArray[] ) throws Throwable
    {
        String data = dataArray[2];

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.format("%s%n", data);
        }

    }
}
