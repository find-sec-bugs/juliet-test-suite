/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__console_readLine_51b.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: console_readLine Read data from the console using readLine()
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__console_readLine_51b
{
    public void badSink(String data ) throws Throwable
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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
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

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
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
