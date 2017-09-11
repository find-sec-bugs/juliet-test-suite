/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE572_Call_to_Thread_run_Instead_of_start__basic_01.java
Label Definition File: CWE572_Call_to_Thread_run_Instead_of_start__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 572 Call to Thread run instead of Thread start
* Sinks:
*    GoodSink: calls thread start
*    BadSink : calls thread run
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE572_Call_to_Thread_run_Instead_of_start;

import testcasesupport.*;

public class CWE572_Call_to_Thread_run_Instead_of_start__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        IO.writeLine("bad() Main thread name is: " + Thread.currentThread().getName());
        Thread threadOne = new Thread()
        {
            public void run()
            {
                IO.writeLine("bad() In thread: " + Thread.currentThread().getName());
            }
        };

        threadOne.run(); /* FLAW: Called Thread.run() instead of Thread.start() */

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        IO.writeLine("good() Main thread name is: " + Thread.currentThread().getName());
        Thread threadTwo = new Thread()
        {
            public void run()
            {
                IO.writeLine("good() In thread: " + Thread.currentThread().getName());
            }
        };

        threadTwo.start(); /* FIX: Correctly called Thread.start() */

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

