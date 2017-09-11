/*
 * @description Demonstrates a deadlock caused by obtaining locks in a different order in different functions in multithreaded code that accesses shared variables.
 * 
 * */
package testcases.CWE833_Deadlock;

import java.util.concurrent.locks.ReentrantLock;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE833_Deadlock__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    /* bad(): Obtain locks in different order in helperAddBad and helperMultiplyBad, causing a deadlock */
    static private int intBadNumber1 = 3;
    static private final ReentrantLock BAD_NUMBER1_REENTRANTLOCK = new ReentrantLock();

    static private int intBadNumber2 = 5;
    static private final ReentrantLock BAD_NUMBER2_REENTRANTLOCK = new ReentrantLock();

    static public void helperAddBad()
    {
        BAD_NUMBER1_REENTRANTLOCK.lock();
        
        try 
        { 
            Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
        } 
        catch (InterruptedException exceptInterrupted) 
        {
            IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
        }
        
        BAD_NUMBER2_REENTRANTLOCK.lock();
        
        try 
        {
            intBadNumber1 = intBadNumber1 + intBadNumber2;
        } 
        finally 
        {
            BAD_NUMBER2_REENTRANTLOCK.unlock();
            BAD_NUMBER1_REENTRANTLOCK.unlock();
        }
    }

    static public void helperMultiplyBad()
    {
        /* FLAW: obtain locks in the opposite order as in helperAddBad() */
        BAD_NUMBER2_REENTRANTLOCK.lock(); 
        
        try 
        { 
            Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
        } 
        catch (InterruptedException exceptInterrupted) 
        {
            IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
        }
        
        BAD_NUMBER1_REENTRANTLOCK.lock();
        
        try 
        {
            intBadNumber1 = intBadNumber1 * intBadNumber2;
        } 
        finally 
        {
            BAD_NUMBER1_REENTRANTLOCK.unlock();
            BAD_NUMBER2_REENTRANTLOCK.unlock();
        }
    }

    public void bad() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE833_Deadlock__ReentrantLock_Thread_01.helperAddBad(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE833_Deadlock__ReentrantLock_Thread_01.helperMultiplyBad(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish (though they never will since they are deadlocked) */
        threadOne.join();
        threadTwo.join();

        /* write output */
        IO.writeLine(intBadNumber1);
    }

    /* good1() - obtain locks in same order in helperAddGood1() and helperMultiplyGood1() */
    static private int intGood1Number1 = 3;
    static private final ReentrantLock GOOD1_NUMBER1_REENTRANTLOCK = new ReentrantLock();

    static private int intGood1Number2 = 5;
    static private final ReentrantLock GOOD1_NUMBER2_REENTRANTLOCK = new ReentrantLock();

    static public void helperAddGood1()
    {
        GOOD1_NUMBER1_REENTRANTLOCK.lock();
        
        try 
        { 
            Thread.sleep(1000); /* sleep for a bit to allow a context switch */
        } 
        catch (InterruptedException exceptInterrupted) 
        {
            IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
        }
        
        GOOD1_NUMBER2_REENTRANTLOCK.lock();
        
        try 
        {
            intGood1Number1 = intGood1Number1 + intGood1Number2;
        } 
        finally 
        {
            GOOD1_NUMBER2_REENTRANTLOCK.unlock();
            GOOD1_NUMBER1_REENTRANTLOCK.unlock();
        }
    }

    static public void helperMultiplyGood1()
    {
        /* FIX: obtain locks in the same order as in helperAddGood1() */
        GOOD1_NUMBER1_REENTRANTLOCK.lock(); 
        
        try 
        { 
            Thread.sleep(1000); /* sleep for a bit to allow a context switch */
        } 
        catch (InterruptedException exceptInterrupted) 
        {
            IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
        }
        
        GOOD1_NUMBER2_REENTRANTLOCK.lock();
        
        try 
        {
            intGood1Number1 = intGood1Number1 * intGood1Number2;
        } 
        finally 
        {
            GOOD1_NUMBER2_REENTRANTLOCK.unlock();
            GOOD1_NUMBER1_REENTRANTLOCK.unlock();
        }
    }

    public void good1() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE833_Deadlock__ReentrantLock_Thread_01.helperAddGood1(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE833_Deadlock__ReentrantLock_Thread_01.helperMultiplyGood1(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();

        /* write output */
        IO.writeLine(intGood1Number1);
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
    public static void main(String[] args) 
            throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        mainFromParent(args);
    }
}
