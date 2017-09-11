/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__getParameter_Servlet_74b.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__getParameter_Servlet_74b
{
    public void badSink(HashMap<Integer,String> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataHashMap.get(2);

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

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(HashMap<Integer,String> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataHashMap.get(2);

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

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(HashMap<Integer,String> dataHashMap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = dataHashMap.get(2);

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
