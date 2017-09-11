/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE396_Catch_Generic_Exception__Exception_03.java
Label Definition File: CWE396_Catch_Generic_Exception.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 396 An overly broad catch statement may cause errors in program execution if unexpected exceptions are thrown
* Sinks: Exception
*    GoodSink: Catch specific exception type (NumberFormatException)
*    BadSink : Catch Exception, which is overly generic
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE396_Catch_Generic_Exception;

import testcasesupport.*;

public class CWE396_Catch_Generic_Exception__Exception_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (5 == 5)
        {
            try
            {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (Exception exception) /* FLAW: Catch Exception, which is overly generic */
            {
                IO.writeLine("Caught Exception");
                throw exception; /* Rethrow */
            }
        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if (5 != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            try
            {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (NumberFormatException exceptNumberFormat) /* FIX: Catch NumberFormatException */
            {
                IO.writeLine("Caught Exception");
                throw exceptNumberFormat; /* Rethrow */
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (5 == 5)
        {
            try
            {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (NumberFormatException exceptNumberFormat) /* FIX: Catch NumberFormatException */
            {
                IO.writeLine("Caught Exception");
                throw exceptNumberFormat; /* Rethrow */
            }
        }
    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
