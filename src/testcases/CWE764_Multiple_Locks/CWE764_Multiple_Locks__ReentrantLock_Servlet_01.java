/*
 * @description Demonstrates use of lock() more times than unlock() in a Servlet that updates a shared variable.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */
package testcases.CWE764_Multiple_Locks;

import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE764_Multiple_Locks__ReentrantLock_Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* bad(): Use lock() twice and unlock() once */
    static private int intBad = 1;
    static private final ReentrantLock REENTRANT_LOCK_BAD = new ReentrantLock();

    static public void helperBad() 
    {
        REENTRANT_LOCK_BAD.lock(); 
        REENTRANT_LOCK_BAD.lock(); /* FLAW: Code uses lock() twice (and unlock() once), so no other threads will ever be able to get lock */

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
