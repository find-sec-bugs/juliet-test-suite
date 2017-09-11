/*
 * @description Demonstrates use of unlock() more times than lock() in multithreaded code that accesses a shared variable.
 * 
 * */
package testcases.CWE765_Multiple_Unlocks;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE765_Multiple_Unlocks__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    /* bad(): Use lock() once and unlock() twice */
    static private int intBad = 1;
    static private final ReentrantLock REENTRANT_LOCK_BAD = new ReentrantLock();

    static public void helperBad() 
    {
        REENTRANT_LOCK_BAD.lock(); 

        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intBad = intBad * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_BAD.unlock();    
            REENTRANT_LOCK_BAD.unlock(); /* FLAW: Code uses unlock() twice (and lock() once), which will throw an IllegalMonitorStateException */
        }
    }

    public void bad() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE765_Multiple_Unlocks__ReentrantLock_Thread_01.helperBad(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE765_Multiple_Unlocks__ReentrantLock_Thread_01.helperBad(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();

        /* Write output */
        IO.writeLine(intBad);  
    }

    /* good1(): Use a ReentrantLock properly (use lock() once and unlock() once) */
    static private int intGood1 = 1;
    static private final ReentrantLock REENTRANT_LOCK_GOOD1 = new ReentrantLock();

    static public void helperGood1() 
    {
        REENTRANT_LOCK_GOOD1.lock(); 
        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intGood1 = intGood1 * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_GOOD1.unlock(); /* FIX: Only use unlock() once */
        }
    }

    private void good1() throws InterruptedException
    {        
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE765_Multiple_Unlocks__ReentrantLock_Thread_01.helperGood1(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE765_Multiple_Unlocks__ReentrantLock_Thread_01.helperGood1(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();

        /* Write output */
        IO.writeLine(intGood1);
    }  

    public void good() throws InterruptedException 
    {
        good1();
    }

    /* Below is the main(). It is only used when building this testcase on 
     * its own for testing or for building a binary to use in testing binary 
     * analysis tools. It is not used when compiling all the testcases as one 
     * application, which is how source code analysis tools are tested. 
	 */ 
    public static void main(String[] args) 
            throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        mainFromParent(args);
    }
}
