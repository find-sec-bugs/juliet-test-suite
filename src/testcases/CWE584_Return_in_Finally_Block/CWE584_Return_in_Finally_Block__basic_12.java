/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE584_Return_in_Finally_Block__basic_12.java
Label Definition File: CWE584_Return_in_Finally_Block__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 584 Return in Finally Block
* Sinks:
*    GoodSink: no return in finally block
*    BadSink : return in finally
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE584_Return_in_Finally_Block;

import testcasesupport.*;

public class CWE584_Return_in_Finally_Block__basic_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
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

    public void good() throws Throwable
    {
        good1();
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
