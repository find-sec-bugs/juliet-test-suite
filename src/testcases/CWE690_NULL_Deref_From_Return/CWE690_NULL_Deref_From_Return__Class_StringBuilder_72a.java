/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_StringBuilder_72a.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;
import java.util.Vector;

public class CWE690_NULL_Deref_From_Return__Class_StringBuilder_72a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Call getStringBuilderBad(), which may return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderBad();

        Vector<StringBuilder> dataVector = new Vector<StringBuilder>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE690_NULL_Deref_From_Return__Class_StringBuilder_72b()).badSink(dataVector  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;

        /* FIX: call getStringBuilderGood(), which will never return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderGood();

        Vector<StringBuilder> dataVector = new Vector<StringBuilder>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE690_NULL_Deref_From_Return__Class_StringBuilder_72b()).goodG2BSink(dataVector  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Call getStringBuilderBad(), which may return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBuilderBad();

        Vector<StringBuilder> dataVector = new Vector<StringBuilder>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE690_NULL_Deref_From_Return__Class_StringBuilder_72b()).goodB2GSink(dataVector  );
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
