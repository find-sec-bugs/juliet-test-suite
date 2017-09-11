/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__database_format_22b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__database_format_22b
{
    public void badSink(String data ) throws Throwable
    {
        if (CWE134_Uncontrolled_Format_String__database_format_22a.badPublicStatic)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1Sink(String data ) throws Throwable
    {
        if (CWE134_Uncontrolled_Format_String__database_format_22a.goodB2G1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2Sink(String data ) throws Throwable
    {
        if (CWE134_Uncontrolled_Format_String__database_format_22a.goodB2G2PublicStatic)
        {
            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        if (CWE134_Uncontrolled_Format_String__database_format_22a.goodG2BPublicStatic)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }
}
