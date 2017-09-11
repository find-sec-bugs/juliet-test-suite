/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_StringBuilder_74b.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;
import java.util.HashMap;

public class CWE690_NULL_Deref_From_Return__Class_StringBuilder_74b
{
    public void badSink(HashMap<Integer,StringBuilder> dataHashMap ) throws Throwable
    {
        StringBuilder data = dataHashMap.get(2);

        /* POTENTIAL FLAW: data could be null */
        String stringTrimmed = data.toString().trim();

        IO.writeLine(stringTrimmed);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(HashMap<Integer,StringBuilder> dataHashMap ) throws Throwable
    {
        StringBuilder data = dataHashMap.get(2);

        /* POTENTIAL FLAW: data could be null */
        String stringTrimmed = data.toString().trim();

        IO.writeLine(stringTrimmed);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(HashMap<Integer,StringBuilder> dataHashMap ) throws Throwable
    {
        StringBuilder data = dataHashMap.get(2);

        /* FIX: explicit check for null */
        if (data != null)
        {
            String stringTrimmed = data.toString().trim();
            IO.writeLine(stringTrimmed);
        }

    }
}
