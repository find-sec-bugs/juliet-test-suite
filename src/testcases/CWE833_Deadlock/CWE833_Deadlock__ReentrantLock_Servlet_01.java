/*
 * @description Demonstrates a deadlock caused by obtaining locks in a different order in different functions in a Servlet that accesses shared variables.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */
package testcases.CWE833_Deadlock;

import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE833_Deadlock__ReentrantLock_Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* bad(): Obtain locks in different order in helperAddBad and helperMultiplyBad, causing a deadlock */
    static private int intBadNumber1 = 3;
    static private final ReentrantLock BAD_NUMBER1_REENTRANTLOCK = new ReentrantLock();

    static private int intBadNumber2 = 5;
    static private final ReentrantLock BAD_NUMBER2_REENTRANTLOCK = new ReentrantLock();

    static public void helperAddBad()
    {
        BAD_NUMBER1_REENTRANTLOCK.lock();

        /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since
		 * that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

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

        /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since
		 * that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

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

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        /* Branch so that not all requests call the same method.  If a valid request and an invalid
         * one come in at the same time, a deadlock will result */
        if(request.isRequestedSessionIdValid()) 
        {
            helperAddBad();
        } 
        else 
        {
            helperMultiplyBad();
        }

        /* write output */
        response.getWriter().write(intBadNumber1);
    }

    /* good1() - obtain locks in same order in helperAddGood1() and helperMultiplyGood1() */
    static private int intGood1Number1 = 3;
    static private final ReentrantLock GOOD1_NUMBER1_REENTRANTLOCK = new ReentrantLock();

    static private int intGood1Number2 = 5;
    static private final ReentrantLock GOOD1_NUMBER2_REENTRANTLOCK = new ReentrantLock();

    static public void helperAddGood1()
    {
        GOOD1_NUMBER1_REENTRANTLOCK.lock();

        /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since
		 * that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

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

        /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since
		 * that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

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

    public void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        /* Branch so that not all requests call the same method. */
        if(request.isRequestedSessionIdValid()) 
        {
            helperAddGood1();
        }
        else 
        {
            helperMultiplyGood1();
        }

        /* write output */
        response.getWriter().write(intGood1Number1);
    }  

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        good1(request, response);
    } 
}
