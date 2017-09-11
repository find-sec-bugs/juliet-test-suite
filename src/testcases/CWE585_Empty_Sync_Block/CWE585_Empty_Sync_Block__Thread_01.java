/*
 * @description Demonstrates a synchronized block that is empty (and therefore allowing unsynchronized updates to a shared variable). 
 * 
 * */

package testcases.CWE585_Empty_Sync_Block;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE585_Empty_Sync_Block__Thread_01 extends AbstractTestCase 
{
    /* bad(): Empty synchronized block */
    static private int intBad = 1;

    static public void helperBad()
    {
        synchronized(CWE585_Empty_Sync_Block__Thread_01.class) 
        {
            /* FLAW: empty synchronized block - should cover whole method */
        }
    
        intBad = intBad * 2;
    }

    public void bad() throws InterruptedException 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE585_Empty_Sync_Block__Thread_01.helperBad(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE585_Empty_Sync_Block__Thread_01.helperBad(); 
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

    /* good1(): Use synchronized block to cover whole method */
    static private int intGood1 = 1;

    static public void helperGood1() 
    {
        synchronized(CWE585_Empty_Sync_Block__Thread_01.class) 
        { /* FIX: synchronized block covers whole method */
            intGood1 = intGood1 * 2;
        }
    }

    private void good1() throws InterruptedException
    {   
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE585_Empty_Sync_Block__Thread_01.helperGood1(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE585_Empty_Sync_Block__Thread_01.helperGood1(); 
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
