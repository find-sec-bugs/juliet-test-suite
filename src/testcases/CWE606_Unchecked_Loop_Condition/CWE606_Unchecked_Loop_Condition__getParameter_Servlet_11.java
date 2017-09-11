/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__getParameter_Servlet_11.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-11.tmpl.java
*/
/*
* @description
* CWE: 606 Unchecked Input for Loop Condition
* BadSource: getParameter_Servlet Read data from a querystring using getParameter()
* GoodSource: hardcoded int in string form
* Sinks:
*    GoodSink: validate loop variable
*    BadSink : loop variable not validated
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import javax.servlet.http.*;


public class CWE606_Unchecked_Loop_Condition__getParameter_Servlet_11 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsTrue())
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

        if(IO.staticReturnsTrue())
        {
            int numberOfLoops;
            try
            {
                numberOfLoops = Integer.parseInt(data);
            }
            catch (NumberFormatException exceptNumberFormat)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                numberOfLoops = 1;
            }
            for (int i=0; i < numberOfLoops; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.staticReturnsTrue() to IO.staticReturnsFalse() */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a hardcoded int as a string */
            data = "5";

        }

        if (IO.staticReturnsTrue())
        {
            int numberOfLoops;
            try
            {
                numberOfLoops = Integer.parseInt(data);
            }
            catch (NumberFormatException exceptNumberFormat)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                numberOfLoops = 1;
            }
            for (int i=0; i < numberOfLoops; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (IO.staticReturnsTrue())
        {
            /* FIX: Use a hardcoded int as a string */
            data = "5";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticReturnsTrue())
        {
            int numberOfLoops;
            try
            {
                numberOfLoops = Integer.parseInt(data);
            }
            catch (NumberFormatException exceptNumberFormat)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                numberOfLoops = 1;
            }
            for (int i=0; i < numberOfLoops; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.staticReturnsTrue() to IO.staticReturnsFalse() */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsTrue())
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

        if (IO.staticReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            int numberOfLoops;
            try
            {
                numberOfLoops = Integer.parseInt(data);
            }
            catch (NumberFormatException exceptNumberFormat)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                numberOfLoops = 1;
            }

            /* FIX: loop number thresholds validated */
            if (numberOfLoops >= 0 && numberOfLoops <= 5)
            {
                for (int i=0; i < numberOfLoops; i++)
                {
                    IO.writeLine("hello world");
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsTrue())
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

        if (IO.staticReturnsTrue())
        {
            int numberOfLoops;
            try
            {
                numberOfLoops = Integer.parseInt(data);
            }
            catch (NumberFormatException exceptNumberFormat)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                numberOfLoops = 1;
            }
            /* FIX: loop number thresholds validated */
            if (numberOfLoops >= 0 && numberOfLoops <= 5)
            {
                for (int i=0; i < numberOfLoops; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
