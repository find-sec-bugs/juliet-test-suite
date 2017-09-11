/*
 * @description Demonstrates lack of any synchronization or locks in a Servlet that updates a shared variable.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */

package testcases.CWE609_Double_Checked_Locking;

import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE609_Double_Checked_Locking__Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* Bad() - Use of Double Checked Locking */
    private static String stringBad = null;
    
    /* FLAW: Insufficient "Double-Checked Locking" in this method - in certain circumstances, this can lead to stringBad being initialized twice.
	 * See http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html for details. */
    public static String helperBad() 
    { 
        if (stringBad == null)
        {
            synchronized(CWE609_Double_Checked_Locking__Servlet_01.class)
            {
                if (stringBad == null)
                {
                    stringBad = "stringBad";
                }
            }
        }
        return stringBad;
    }
  
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        response.getWriter().write(helperBad());
    }
  
  
    /* Good1() - Add volatile keyword for Double Checked Locking 
     * volatile valid fix for Java 5 and later */
    private volatile static String stringGood1 = null;  /* FIX: Added "volatile" here */
    
    public static String helperGood1() 
    { 
        if (stringGood1 == null)
        {
            synchronized(CWE609_Double_Checked_Locking__Servlet_01.class)
            {
                if (stringGood1 == null)
                {
                    stringGood1 = "stringGood1";
                }
            }
        }
        return stringGood1;
    }
  
    public void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        response.getWriter().write(helperGood1());
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
  
    public void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        response.getWriter().write(helperGood2());
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
  
    public void good3(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        response.getWriter().write(helperGood3());
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
  
    public void good4(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        response.getWriter().write(helperGood4());
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
  
    public void good5(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        response.getWriter().write(helperGood5());
    }
  
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        good1(request, response);
        good2(request, response);
        good3(request, response);
        good4(request, response);
        good5(request, response);
    } 
}
