/*
 * @description Demonstrates a synchronized block that is empty (and therefore allowing unsynchronized updates to a shared variable).  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */

package testcases.CWE585_Empty_Sync_Block;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE585_Empty_Sync_Block__Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* bad(): Empty synchronized block */
    static private int intBad = 1;

    static public void helperBad()
    {
        synchronized(CWE585_Empty_Sync_Block__Servlet_01.class) 
        {
            /* FLAW: empty synchronized block - should cover whole method */
        }
    
        intBad = intBad * 2;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException 
    {
        helperBad();
        response.getWriter().write(intBad);
    }

    /* good1(): Use synchronized block to cover whole method */
    static private int intGood1 = 1;

    static public void helperGood1() 
    {
        synchronized(CWE585_Empty_Sync_Block__Servlet_01.class) 
        { /* FIX: synchronized block covers whole method */
            intGood1 = intGood1 * 2;
        }
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException
    {        
        helperGood1();
        response.getWriter().write(intGood1);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException 
    {
        good1(request, response);
    } 
}
