/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__getParameter_Servlet_HashSet_54b.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-54b.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashSet
 *    BadSink : Create a HashSet using data as the initial size
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE789_Uncontrolled_Mem_Alloc__getParameter_Servlet_HashSet_54b
{
    public void badSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE789_Uncontrolled_Mem_Alloc__getParameter_Servlet_HashSet_54c()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE789_Uncontrolled_Mem_Alloc__getParameter_Servlet_HashSet_54c()).goodG2BSink(data , request, response);
    }
}
