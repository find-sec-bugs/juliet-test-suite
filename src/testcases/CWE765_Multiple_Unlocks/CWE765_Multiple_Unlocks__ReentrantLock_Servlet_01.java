/*
 * @description Demonstrates use of unlock() more times than lock() in a Servlet that updates a shared variable.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */
package testcases.CWE765_Multiple_Unlocks;

import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE765_Multiple_Unlocks__ReentrantLock_Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* bad(): Use lock() twice and unlock() once */
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

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        helperBad();
        response.getWriter().write(intBad);
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

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {        
        helperGood1();
        response.getWriter().write(intGood1);
    }  

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        good1(request, response);
    } 
}
