/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_equals_73a.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: System_getProperty Set data to return of System.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_equals_73a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        LinkedList<String> dataLinkedList = new LinkedList<String>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_73b()).badSink(dataLinkedList  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        LinkedList<String> dataLinkedList = new LinkedList<String>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_73b()).goodG2BSink(dataLinkedList  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = System.getProperty("CWE690");

        LinkedList<String> dataLinkedList = new LinkedList<String>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE690_NULL_Deref_From_Return__System_getProperty_equals_73b()).goodB2GSink(dataLinkedList  );
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
