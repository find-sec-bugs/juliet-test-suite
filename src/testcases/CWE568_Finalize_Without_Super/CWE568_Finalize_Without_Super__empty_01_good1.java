/*
 * @description protected finalize method calls super.finalize()
 * 
 * */
package testcases.CWE568_Finalize_Without_Super;

import java.util.logging.Level;

import testcasesupport.AbstractTestCaseClassIssueGood;
import testcasesupport.IO;

public class CWE568_Finalize_Without_Super__empty_01_good1 extends AbstractTestCaseClassIssueGood 
{
    public class HelperClass 
    {
        /* The finalize method of built-in Java objects are hidden, so a custom object is used instead.
         * Alternative to extend an object like FileInputStream and invoke the finalize() method from within
         * by overriding the close() method. e.g. super.finalize()
         */
        private String message;
        
        public HelperClass() 
        {
            this.message = "hello world";
        }
        
        public void printMessage() 
        {
            IO.writeLine(this.message);
        }
        
        protected void finalize() 
        {
            try
            {
                IO.writeLine("finalizing HelperClass");
            }
            finally
            {
                try
                {
                    super.finalize();
                }
                catch (Throwable exceptThrowable)
                {
                    IO.logger.log(Level.WARNING, "caught an exception calling super.finalize() from the HelperClass", exceptThrowable);                    
                }
            }
        }
    }
    
    public class GoodClass extends HelperClass 
    {        
        protected void finalize() 
        {
            try 
            {
                /* cleanup code here */
                IO.writeLine("finalizing GoodClass");
            }
            finally
            {
                /* FIX: calling super.finalize() */
                try 
                {
                    super.finalize();
                } 
                catch (Throwable exceptThrowable) 
                {
                    IO.logger.log(Level.WARNING, "caught an exception calling super.finalize() from the GoodClass", exceptThrowable);
                }
            }
        }
    }
    
    public void good() throws Throwable 
    {
        good1();
    }
    
    private void good1()
    {
        GoodClass objectGood = new GoodClass();
        
        try
        {
            objectGood.printMessage();
        } 
        /* Ignore catching exceptions as we're only worried about the finally block */
        finally 
        {
            /* cleanup */
            objectGood = null; /* set the object = null, and (implicitly) let the GC invoke finalize */
        }
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
