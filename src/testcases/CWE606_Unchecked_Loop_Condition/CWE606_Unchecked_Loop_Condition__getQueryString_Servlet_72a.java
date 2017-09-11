/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__getQueryString_Servlet_72a.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;
import java.util.Vector;

import javax.servlet.http.*;

import java.util.StringTokenizer;

public class CWE606_Unchecked_Loop_Condition__getQueryString_Servlet_72a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");
            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE606_Unchecked_Loop_Condition__getQueryString_Servlet_72b()).badSink(dataVector , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded int as a string */
        data = "5";

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE606_Unchecked_Loop_Condition__getQueryString_Servlet_72b()).goodG2BSink(dataVector , request, response );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");
            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE606_Unchecked_Loop_Condition__getQueryString_Servlet_72b()).goodB2GSink(dataVector , request, response );
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
