/*
 * @description Demonstrates a deadlock caused by synchronized methods in objects that call one another in multithreaded code.  Implementation based on http://download.oracle.com/javase/tutorial/essential/concurrency/deadlock.html.
 * 
 * */
package testcases.CWE833_Deadlock;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE833_Deadlock__synchronized_methods_Thread_01 extends AbstractTestCase 
{
    /* Bad - Call to a synchronized method on another object while holding lock on this object */
    public synchronized void helperBowBad(CWE833_Deadlock__synchronized_methods_Thread_01 bower) 
    {
        IO.writeLine("helperBowBad");
    
        try 
        { 
            Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
        } 
        catch (InterruptedException exceptInterrupted) 
        {
            IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
        }
            
        bower.helperBowBackBad(this); /* FLAW: Call to a synchronized method on another object while holding lock on this object */
    }
    
    public synchronized void helperBowBackBad(CWE833_Deadlock__synchronized_methods_Thread_01 bower) 
    {
        IO.writeLine("helperBowBackBad");
    }

    public void bad() throws InterruptedException 
    {
        /* Create objects */
        final CWE833_Deadlock__synchronized_methods_Thread_01 FINAL_THREAD_ONE = new CWE833_Deadlock__synchronized_methods_Thread_01();
        final CWE833_Deadlock__synchronized_methods_Thread_01 FINAL_THREAD_TWO = new CWE833_Deadlock__synchronized_methods_Thread_01();

        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                FINAL_THREAD_ONE.helperBowBad(FINAL_THREAD_TWO); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                FINAL_THREAD_TWO.helperBowBad(FINAL_THREAD_ONE); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();
          
        /* Wait for threads to finish (though they never will since they are deadlocked) */
        threadOne.join();
        threadTwo.join();
    }


    /* Good1 - Call to synchronized method on another object is made after giving up "lock" on this object */
    public void helperBowGood1(CWE833_Deadlock__synchronized_methods_Thread_01 bower) 
    {
        synchronized(this) 
        {
            IO.writeLine("helperBowGood1");
            
            try 
            { 
                Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
            } 
            catch (InterruptedException exceptInterrupted) 
            {
                IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
            }
        }
        
        bower.helperBowBackGood1(this); /* FIX: Call to synchronized method on another object is made after giving up "lock" on this object */
    }

    public synchronized void helperBowBackGood1(CWE833_Deadlock__synchronized_methods_Thread_01 bower) 
    {
        IO.writeLine("helperBowBackGood1");
    }

    private void good1()  throws InterruptedException 
    {
        /* Create objects */
        final CWE833_Deadlock__synchronized_methods_Thread_01 FINAL_THREAD_ONE = new CWE833_Deadlock__synchronized_methods_Thread_01();
        final CWE833_Deadlock__synchronized_methods_Thread_01 FINAL_THREAD_TWO = new CWE833_Deadlock__synchronized_methods_Thread_01();

        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                FINAL_THREAD_ONE.helperBowGood1(FINAL_THREAD_TWO); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                FINAL_THREAD_TWO.helperBowGood1(FINAL_THREAD_ONE); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();
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
