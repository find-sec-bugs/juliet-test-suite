/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__getParameter_Servlet_HashSet_74b.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-74b.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashSet
 *    BadSink : Create a HashSet using data as the initial size
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.util.HashSet;

public class CWE789_Uncontrolled_Mem_Alloc__getParameter_Servlet_HashSet_74b
{
    public void badSink(HashMap<Integer,Integer> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = dataHashMap.get(2);

        /* POTENTIAL FLAW: Create a HashSet using data as the initial size.  data may be very large, creating memory issues */
        HashSet intHashSet = new HashSet(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(HashMap<Integer,Integer> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = dataHashMap.get(2);

        /* POTENTIAL FLAW: Create a HashSet using data as the initial size.  data may be very large, creating memory issues */
        HashSet intHashSet = new HashSet(data);

    }
}
