/*
 * @description Demonstrates a deadlock caused by synchronized methods in objects that call one another in a Servlet.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.  Implementation based on http://download.oracle.com/javase/tutorial/essential/concurrency/deadlock.html.
 * 
 * */
package testcases.CWE833_Deadlock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;

import testcasesupport.IO;
import testcasesupport.AbstractTestCaseServlet;

public class CWE833_Deadlock__synchronized_methods_Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* Bad - Call to a synchronized method on another object while holding lock on this object */

    /* Create bad static objects */
    static CWE833_Deadlock__synchronized_methods_Servlet_01 objectBadFirst = new CWE833_Deadlock__synchronized_methods_Servlet_01();
    static CWE833_Deadlock__synchronized_methods_Servlet_01 objectBadSecond = new CWE833_Deadlock__synchronized_methods_Servlet_01();

    public synchronized void helperBowBad(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) 
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
        
        /* FLAW: Call to a synchronized method on another object while holding lock on this object */
        bower.helperBowBackBad(this); 
    }

    public synchronized void helperBowBackBad(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) 
    {
        IO.writeLine("helperBowBackBad");
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        /* Branch so that not all requests call the same method.  If a valid request and an invalid
         * one come in at the same time, a deadlock will result */
        if(request.isRequestedSessionIdValid()) 
        {
            objectBadFirst.helperBowBad(objectBadSecond);
        } 
        else 
        {
            objectBadSecond.helperBowBad(objectBadFirst);
        }
    }

    /* Good1 - Call to synchronized method on another object is made after giving up "lock" on this object */

    /* Create good1 static objects */
    static CWE833_Deadlock__synchronized_methods_Servlet_01 objectGood1First = new CWE833_Deadlock__synchronized_methods_Servlet_01();
    static CWE833_Deadlock__synchronized_methods_Servlet_01 objectGood1Second = new CWE833_Deadlock__synchronized_methods_Servlet_01();

    public void helperBowGood1(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) {
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
        
        /* FIX: Call to synchronized method on another object is made after giving up "lock" on this object */
        bower.helperBowBackGood1(this); 
    }

    public synchronized void helperBowBackGood1(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) 
    {
        IO.writeLine("helperBowBackGood1");
    }

    public void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        /* Branch so that not all requests call the same method.  If a valid request and an invalid
         * one come in at the same time, a deadlock will result */
        if(request.isRequestedSessionIdValid()) 
        {
            objectGood1First.helperBowGood1(objectGood1Second);
        } 
        else 
        {
            objectGood1Second.helperBowGood1(objectGood1First);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        good1(request, response);
    } 
}
