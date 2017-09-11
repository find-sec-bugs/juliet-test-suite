/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__File_format_52b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__File_format_52b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__File_format_52c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__File_format_52c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__File_format_52c()).goodB2GSink(data );
    }
}
