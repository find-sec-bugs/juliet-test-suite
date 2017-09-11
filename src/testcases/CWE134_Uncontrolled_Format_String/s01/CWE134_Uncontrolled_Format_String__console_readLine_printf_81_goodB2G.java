/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__console_readLine_printf_81_goodB2G.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: console_readLine Read data from the console using readLine()
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__console_readLine_printf_81_goodB2G extends CWE134_Uncontrolled_Format_String__console_readLine_printf_81_base
{
    public void action(String data ) throws Throwable
    {

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.printf("%s%n", data);
        }

    }
}
