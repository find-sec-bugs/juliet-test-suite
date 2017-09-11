/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__PropertiesFile_ArrayList_67b.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-67b.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: ArrayList
 *    BadSink : Create an ArrayList using data as the initial size
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.ArrayList;

public class CWE789_Uncontrolled_Mem_Alloc__PropertiesFile_ArrayList_67b
{
    public void badSink(CWE789_Uncontrolled_Mem_Alloc__PropertiesFile_ArrayList_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

        /* POTENTIAL FLAW: Create an ArrayList using data as the initial size.  data may be very large, creating memory issues */
        ArrayList intArrayList = new ArrayList(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE789_Uncontrolled_Mem_Alloc__PropertiesFile_ArrayList_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

        /* POTENTIAL FLAW: Create an ArrayList using data as the initial size.  data may be very large, creating memory issues */
        ArrayList intArrayList = new ArrayList(data);

    }
}
