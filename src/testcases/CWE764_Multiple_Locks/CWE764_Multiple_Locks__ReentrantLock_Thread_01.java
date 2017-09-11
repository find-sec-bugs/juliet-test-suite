/*
 * @description Demonstrates use of lock() more times than unlock() in multithreaded code that accesses a shared variable.
 * 
 * */
package testcases.CWE764_Multiple_Locks;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE764_Multiple_Locks__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    /* bad(): Use lock() twice and unlock() once */
    static private int intBad = 1;
    static private final ReentrantLock REENTRANT_LOCK_BAD = new ReentrantLock();

    static public void helperBad() 
    {
        REENTRANT_LOCK_BAD.lock(); 
        REENTRANT_LOCK_BAD.lock(); /* FLAW: Code uses lock() twice (and unlock() once), so the second thread will never be able to get lock */

        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intBad = intBad * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_BAD.unlock(); /* Only one unlock(), so the lock will still be held when the thread ends, meaning no other threads can get the lock */
        }
    }

    public void bad() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE764_Multiple_Locks__ReentrantLock_Thread_01.helperBad(); 
            }
        });
       
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE764_Multiple_Locks__ReentrantLock_Thread_01.helperBad(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish (though they never will because the second thread will never be able to get the lock that the first thread
		 * incorrectly locked twice) */
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
        REENTRANT_LOCK_GOOD1.lock(); /* FIX: Only use lock() once */
        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intGood1 = intGood1 * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_GOOD1.unlock();
        }
    }

    private void good1() throws InterruptedException
    {        
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE764_Multiple_Locks__ReentrantLock_Thread_01.helperGood1(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE764_Multiple_Locks__ReentrantLock_Thread_01.helperGood1(); 
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
