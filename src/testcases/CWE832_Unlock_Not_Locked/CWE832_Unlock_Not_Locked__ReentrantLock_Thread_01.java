/*
 * @description Demonstrates use of unlock() on a lock that is not locked in multithreaded code that accesses a shared variable.
 * 
 * */
package testcases.CWE832_Unlock_Not_Locked;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE832_Unlock_Not_Locked__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    /* bad(): Use unlock() on resource that is not locked */
    static private int intBad = 1;
    static private final ReentrantLock REENTRANT_LOCK_BAD = new ReentrantLock();

    static public void helperBad() 
    {
        /* Missing lock here */

        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intBad = intBad * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_BAD.unlock(); /* FLAW: Calls unlock() on a lock which is not locked, which will throw an IllegalMonitorStateException */
        }
    }

    public void bad() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE832_Unlock_Not_Locked__ReentrantLock_Thread_01.helperBad(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE832_Unlock_Not_Locked__ReentrantLock_Thread_01.helperBad(); 
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
        REENTRANT_LOCK_GOOD1.lock();  /* Inserted lock here that was missing in bad() */
        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intGood1 = intGood1 * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_GOOD1.unlock(); /* FIX: Only unlock() a lock that has been locked. */
        }
    }

    private void good1() throws InterruptedException
    {        
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE832_Unlock_Not_Locked__ReentrantLock_Thread_01.helperGood1(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE832_Unlock_Not_Locked__ReentrantLock_Thread_01.helperGood1(); 
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
