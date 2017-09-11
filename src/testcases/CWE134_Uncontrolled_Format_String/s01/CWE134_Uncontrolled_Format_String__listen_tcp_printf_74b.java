/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__listen_tcp_printf_74b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;
import java.util.HashMap;

public class CWE134_Uncontrolled_Format_String__listen_tcp_printf_74b
{
    public void badSink(HashMap<Integer,String> dataHashMap ) throws Throwable
    {
        String data = dataHashMap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(HashMap<Integer,String> dataHashMap ) throws Throwable
    {
        String data = dataHashMap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(HashMap<Integer,String> dataHashMap ) throws Throwable
    {
        String data = dataHashMap.get(2);

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.printf("%s%n", data);
        }

    }
}
