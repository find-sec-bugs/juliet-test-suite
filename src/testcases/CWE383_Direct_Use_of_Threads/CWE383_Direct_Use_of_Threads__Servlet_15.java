/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE383_Direct_Use_of_Threads__Servlet_15.java
Label Definition File: CWE383_Direct_Use_of_Threads__Servlet.label.xml
Template File: point-flaw-badonly-15.tmpl.java
*/
/*
* @description
* CWE: 383 J2EE Bad Practices Direct Use Of Threads
* Sinks:
*    BadSink : performs thread management
*     BadOnly (No GoodSink)
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE383_Direct_Use_of_Threads;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE383_Direct_Use_of_Threads__Servlet_15 extends AbstractTestCaseServletBadOnly
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch (7)
        {
        case 7:
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
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
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
