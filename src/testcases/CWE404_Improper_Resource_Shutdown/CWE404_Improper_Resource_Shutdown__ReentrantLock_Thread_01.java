/*
 * @description Improper release of lock
 * 
 * */
package testcases.CWE404_Improper_Resource_Shutdown;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE404_Improper_Resource_Shutdown__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    static private int intBadNumber = 3;
    static private final ReentrantLock BAD_REENTRANT_LOCK = new ReentrantLock();

    static public void helperBad()
    {
        BAD_REENTRANT_LOCK.lock();
        
        intBadNumber++;
        
        IO.writeLine(intBadNumber);
        
        /* FLAW: lock should be unlocked in a finally block */
        BAD_REENTRANT_LOCK.unlock();       
    }
    
    public void bad() throws Throwable 
    {
        helperBad();
    }

    static private int intGood1Number = 3;
    static private final ReentrantLock GOOD1_REENTRANT_LOCK = new ReentrantLock();

    static public void helperGood1()
    {
        GOOD1_REENTRANT_LOCK.lock();
        
        try
        {
            intGood1Number++;
            
            IO.writeLine(intGood1Number);
        }
        finally
        {
            /* FIX: Unlock the lock within a finally block */
            GOOD1_REENTRANT_LOCK.unlock();
        }
    }
    
    public void good1() throws Throwable 
    {
        helperGood1();
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
