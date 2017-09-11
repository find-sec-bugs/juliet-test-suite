/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__connect_tcp_printf_73b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;
import java.util.LinkedList;

public class CWE134_Uncontrolled_Format_String__connect_tcp_printf_73b
{
    public void badSink(LinkedList<String> dataLinkedList ) throws Throwable
    {
        String data = dataLinkedList.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<String> dataLinkedList ) throws Throwable
    {
        String data = dataLinkedList.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<String> dataLinkedList ) throws Throwable
    {
        String data = dataLinkedList.remove(2);

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.printf("%s%n", data);
        }

    }
}
