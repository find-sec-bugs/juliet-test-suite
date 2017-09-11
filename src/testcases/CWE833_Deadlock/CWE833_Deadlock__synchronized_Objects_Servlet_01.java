/*
 * @description Demonstrates a deadlock caused by synchronizing on objects in a different order in different functions in a Servlet that accesses shared variables.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */
package testcases.CWE833_Deadlock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE833_Deadlock__synchronized_Objects_Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* bad(): Synchronize on objects in different order in helperAddBad and helperMultiplyBad, causing a deadlock */
    static private int intBadNumber1 = 3;
    static private final Object BAD_NUMBER1_LOCK = new Object();

    static private int intBadNumber2 = 5;
    static private final Object BAD_NUMBER2_LOCK = new Object();

    static public void helperAddBad()
    {
        synchronized(BAD_NUMBER1_LOCK) 
        {
            /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep()
			 * since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

            synchronized(BAD_NUMBER2_LOCK) 
            {
                intBadNumber1 = intBadNumber1 + intBadNumber2;
            }
        }
    }

    static public void helperMultiplyBad()
    {
        /* FLAW: Synchronize on objects in the opposite order as in helperAddBad() */
        synchronized(BAD_NUMBER2_LOCK) 
        { 
          /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep()
		   * since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

            synchronized(BAD_NUMBER1_LOCK) 
            {
                intBadNumber1 = intBadNumber1 * intBadNumber2;
            }
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

    /* good1() - Synchronize on objects in same order in helperAddGood1() and helperMultiplyGood1() */
    static private int intGood1Number1 = 3;
    static private final Object GOOD_NUMBER1_LOCK = new Object();

    static private int intGood1Number2 = 5;
    static private final Object GOOD_NUMBER2_LOCK = new Object();

    static public void helperAddGood1()
    {
        synchronized(GOOD_NUMBER1_LOCK) 
        {
            /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep()
			 * since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

            synchronized(GOOD_NUMBER2_LOCK) 
            {
                intGood1Number1 = intGood1Number1 + intGood1Number2;
            }
        }
    }

    static public void helperMultiplyGood1()
    {
        /* FIX: Synchronize on objects in the same order as in helperAddGood1() */
        synchronized(GOOD_NUMBER1_LOCK) 
        { 
          /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep()
		   * since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

            synchronized(GOOD_NUMBER2_LOCK) 
            {
                intGood1Number1 = intGood1Number1 * intGood1Number2;
            }
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
