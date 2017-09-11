/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getParameter_Servlet_14.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-14.tmpl.java
*/
/*
* @description
* CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
* BadSource: getParameter_Servlet Read data from a querystring using getParameter()
* GoodSource: Set data to a hardcoded class name
* BadSink:  Instantiate class named in data
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;


public class CWE470_Unsafe_Reflection__getParameter_Servlet_14 extends AbstractTestCaseServlet
{
    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive == 5)
        {
            /* POTENTIAL FLAW: Read data from a querystring using getParameter */
            data = request.getParameter("name");
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    /* goodG2B1() - use goodsource and badsink by changing IO.staticFive==5 to IO.staticFive!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive == 5)
        {
            /* FIX: Use a hardcoded class name */
            data = "Testing.test";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
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
