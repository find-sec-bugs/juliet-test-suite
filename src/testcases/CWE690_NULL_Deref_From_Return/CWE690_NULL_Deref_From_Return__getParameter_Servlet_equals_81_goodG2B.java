/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__getParameter_Servlet_equals_81_goodG2B.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: getParameter_Servlet Set data to return of getParameter_Servlet
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__getParameter_Servlet_equals_81_goodG2B extends CWE690_NULL_Deref_From_Return__getParameter_Servlet_equals_81_base
{
    public void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* POTENTIAL FLAW: data could be null */
        if(data.equals("CWE690"))
        {
            IO.writeLine("data is CWE690");
        }

    }
}
