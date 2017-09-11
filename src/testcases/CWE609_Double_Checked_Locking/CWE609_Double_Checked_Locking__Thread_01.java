/*
 * @description Use of "Double Checked Locking" which can fail in certain circumstances.  See http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html for details. 
 * 
 * */

package testcases.CWE609_Double_Checked_Locking;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE609_Double_Checked_Locking__Thread_01 extends AbstractTestCase 
{
    /* Bad() - Use of Double Checked Locking */
    private static String stringBad = null;
    
    /* FLAW: Insufficient "Double-Checked Locking" in this method - in certain circumstances, this can lead to stringBad being initialized twice.
	 * See http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html for details. */
    public static String helperBad() 
    { 
        if (stringBad == null)
        {
            synchronized(CWE609_Double_Checked_Locking__Thread_01.class)
            {
                if (stringBad == null)
                {
                    stringBad = "stringBad";
                }
            }
        }
        return stringBad;
    }
    
    public void bad() throws InterruptedException
    { 
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperBad()); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperBad()); 
            }
        });
        
        /* Start threads */
        threadOne.start();
        threadTwo.start();
        
        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();
    }

  
    /* Good1() - Add volatile keyword for Double Checked Locking; 
     * volatile valid fix for Java 5 and later */
    private volatile static String stringGood1 = null; /* FIX: Added "volatile" here */
    
    public static String helperGood1() 
    { 
        if (stringGood1 == null)
        {
            synchronized(CWE609_Double_Checked_Locking__Thread_01.class)
            {
                if (stringGood1 == null)
                {
                    stringGood1 = "stringGood1";
                }
            }
        }
        return stringGood1;
    }
    
    public void good1() throws InterruptedException
    { 
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood1()); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood1()); 
            }
        });
        
        /* Start threads */
        threadOne.start();
        threadTwo.start();
        
        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();
    }
  
  /* Good2() - Use method level synchronization instead of Double Checked Locking */
    private static String stringGood2 = null;
    
    public synchronized static String helperGood2() /* FIX: method is synchronized */
    { 
        if (stringGood2 == null)
        {
            stringGood2 = "stringGood2";
        }
        return stringGood2;
    }
    
    public void good2() throws InterruptedException
    { 
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood2()); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood2()); 
            }
        });
    
    /* Start threads */
    threadOne.start();
    threadTwo.start();
    
    /* Wait for threads to finish */
    threadOne.join();
    threadTwo.join();
    }
  
    
  /* Good3() - Use block synchronization on class instead of Double Checked Locking */
    private static String stringGood3 = null; 

    public static String helperGood3() 
    { 
        /* FIX: Entire block is synchronized on class (not "double checked") */
        synchronized(CWE609_Double_Checked_Locking__Thread_01.class) 
        { 
            if (stringGood3 == null)
            {
                stringGood3 = "stringGood3";
            }
      
        return stringGood3;
        }
    }
    
    public void good3() throws InterruptedException
    { 
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood3()); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood3()); 
            }
        });
    
        /* Start threads */
        threadOne.start();
        threadTwo.start();
        
        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();
    }
  
  
  /* Good4() - Use lock object instead of Double Checked Locking */
    private static String stringGood4 = null; 
    static private final Object stringGood4Lock = new Object();

    public static String helperGood4() 
    { 
        /* FIX: block is synchronized on stringGood4Lock */
        synchronized(stringGood4Lock) 
        { 
            if (stringGood4 == null)
            {
                stringGood4 = "stringGood4";
            }
          return stringGood4;
        }
    }
    
    public void good4() throws InterruptedException
    { 
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood4()); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood4()); 
            }
        });
        
        /* Start threads */
        threadOne.start();
        threadTwo.start();
        
        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();
    }

  
  /* good5() - Use ReentrantLock instead of Double Checked Locking */
    private static String stringGood5 = null; 
    static private final ReentrantLock good5ReentrantLock = new ReentrantLock();

    public static String helperGood5() 
    { 
        good5ReentrantLock.lock(); /* FIX: Block is "protected" with a ReentrantLock */
        
        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try 
        { 
            if (stringGood5 == null)
            {
                stringGood5 = "stringGood5";
            }
            return stringGood5;
        } 
        finally 
        {
            good5ReentrantLock.unlock();
        }
    }
    
    public void good5() throws InterruptedException
    { 
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood5()); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperGood5()); 
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
        good2();
        good3();
        good4();
        good5();
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
