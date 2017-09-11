/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE584_Return_in_Finally_Block__basic_08.java
Label Definition File: CWE584_Return_in_Finally_Block__basic.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 584 Return in Finally Block
* Sinks:
*    GoodSink: no return in finally block
*    BadSink : return in finally
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */

package testcases.CWE584_Return_in_Finally_Block;

import testcasesupport.*;

public class CWE584_Return_in_Finally_Block__basic_08 extends AbstractTestCase
{
    /* The methods below always return the same value, so a tool
     * should be able to figure out that every call to these
     * methods will return true or return false.
     */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (privateReturnsTrue())
        {
            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException exceptIllegalArgument)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                if(true)
                {
                    return; /* FLAW: will always return and prevent finally from completing normally */
                }
                /* INCIDENTAL: 571 Always returns true */
                /* We need the "if(true)" above because the Java Language Spec requires that unreachable code generate a compiler error */
            }
        }
    }

    /* good1() changes privateReturnsTrue() to privateReturnsFalse() */
    private void good1() throws Throwable
    {
        if (privateReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException exceptIllegalArgument)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                /* FIX: cleanup code here and continue */
                IO.writeLine("In finally block, cleaning up");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateReturnsTrue())
        {
            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException exceptIllegalArgument)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                /* FIX: cleanup code here and continue */
                IO.writeLine("In finally block, cleaning up");
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
