/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE584_Return_in_Finally_Block__basic_13.java
Label Definition File: CWE584_Return_in_Finally_Block__basic.label.xml
Template File: point-flaw-13.tmpl.java
*/
/*
* @description
* CWE: 584 Return in Finally Block
* Sinks:
*    GoodSink: no return in finally block
*    BadSink : return in finally
* Flow Variant: 13 Control flow: if(IO.STATIC_FINAL_FIVE==5) and if(IO.STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE584_Return_in_Finally_Block;

import testcasesupport.*;

public class CWE584_Return_in_Finally_Block__basic_13 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE == 5)
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

    /* good1() changes IO.STATIC_FINAL_FIVE==5 to IO.STATIC_FINAL_FIVE!=5 */
    private void good1() throws Throwable
    {
        if (IO.STATIC_FINAL_FIVE != 5)
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
        if (IO.STATIC_FINAL_FIVE == 5)
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
