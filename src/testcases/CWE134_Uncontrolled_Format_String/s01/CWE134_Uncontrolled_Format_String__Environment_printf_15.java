/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Environment_printf_15.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded string
* Sinks: printf
*    GoodSink: dynamic printf format with string defined
*    BadSink : dynamic printf without validation
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE134_Uncontrolled_Format_String.s01;
import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__Environment_printf_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        switch (6)
        {
        case 6:
            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            data = System.getenv("ADD");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (7)
        {
        case 7:
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        String data;

        switch (5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        default:
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        switch (7)
        {
        case 7:
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        String data;

        switch (6)
        {
        case 6:
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (7)
        {
        case 7:
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        String data;

        switch (6)
        {
        case 6:
            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            data = System.getenv("ADD");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        default:
            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
            }
            break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        String data;

        switch (6)
        {
        case 6:
            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            data = System.getenv("ADD");
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
            break;
        }

        switch (7)
        {
        case 7:
            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
            }
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
