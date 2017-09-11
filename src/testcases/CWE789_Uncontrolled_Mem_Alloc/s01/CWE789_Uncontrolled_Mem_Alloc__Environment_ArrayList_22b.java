/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__Environment_ArrayList_22b.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: ArrayList
 *    BadSink : Create an ArrayList using data as the initial size
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

public class CWE789_Uncontrolled_Mem_Alloc__Environment_ArrayList_22b
{
    public int badSource() throws Throwable
    {
        int data;

        if (CWE789_Uncontrolled_Mem_Alloc__Environment_ArrayList_22a.badPublicStatic)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            {
                String stringNumber = System.getenv("ADD");
                if (stringNumber != null) // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(stringNumber.trim());
                    }
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                    }
                }
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public int goodG2B1Source() throws Throwable
    {
        int data;

        if (CWE789_Uncontrolled_Mem_Alloc__Environment_ArrayList_22a.goodG2B1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }

        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public int goodG2B2Source() throws Throwable
    {
        int data;

        if (CWE789_Uncontrolled_Mem_Alloc__Environment_ArrayList_22a.goodG2B2PublicStatic)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        return data;
    }
}
