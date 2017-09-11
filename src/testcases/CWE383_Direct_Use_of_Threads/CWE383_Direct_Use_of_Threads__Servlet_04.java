/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE383_Direct_Use_of_Threads__Servlet_04.java
Label Definition File: CWE383_Direct_Use_of_Threads__Servlet.label.xml
Template File: point-flaw-badonly-04.tmpl.java
*/
/*
* @description
* CWE: 383 J2EE Bad Practices Direct Use Of Threads
* Sinks:
*    BadSink : performs thread management
*     BadOnly (No GoodSink)
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE)
*
* */

package testcases.CWE383_Direct_Use_of_Threads;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE383_Direct_Use_of_Threads__Servlet_04 extends AbstractTestCaseServletBadOnly
{
    /* The variable below are is "final", so a tool should
     * be able to identify that reads of it will always return its
     * initialized value.
     */
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            /* FLAW: performing thread management in J2EE */
            Runnable runnable = new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(10000); /* perform a long calculation */
                    }
                    catch (InterruptedException exceptInterrupted)
                    {
                        IO.writeLine("InterruptedException");
                    }
                }
            };
            Thread threadOne = new Thread(runnable);
            threadOne.start();
            /* wait for the thread, check every second */
            while(true)
            {
                if (!threadOne.isAlive())
                {
                    break;
                }
                Thread.sleep(1000);
            }
            response.getWriter().write("thread is done!");
        }
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
