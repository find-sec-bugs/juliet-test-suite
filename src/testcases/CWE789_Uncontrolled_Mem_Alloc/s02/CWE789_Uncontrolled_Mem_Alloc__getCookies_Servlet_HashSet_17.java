/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__getCookies_Servlet_HashSet_17.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 789 Uncontrolled Memory Allocation
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* BadSink: HashSet Create a HashSet using data as the initial size
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import testcasesupport.*;

import javax.servlet.http.*;


import java.util.logging.Level;

import java.util.HashSet;

public class CWE789_Uncontrolled_Mem_Alloc__getCookies_Servlet_HashSet_17 extends AbstractTestCaseServlet
{
    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                String stringNumber = cookieSources[0].getValue();
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading data from cookie", exceptNumberFormat);
                }
            }
        }

        for (int i = 0; i < 1; i++)
        {
            /* POTENTIAL FLAW: Create a HashSet using data as the initial size.  data may be very large, creating memory issues */
            HashSet intHashSet = new HashSet(data);
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
     * for statement with the one in the for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        for (int i = 0; i < 1; i++)
        {
            /* POTENTIAL FLAW: Create a HashSet using data as the initial size.  data may be very large, creating memory issues */
            HashSet intHashSet = new HashSet(data);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
