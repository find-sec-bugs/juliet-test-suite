/*
 * @description protected finalize method does not call super.finalize()
 * 
 * */
package testcases.CWE568_Finalize_Without_Super;

import java.util.logging.Level;

import testcasesupport.AbstractTestCaseClassIssueBad;
import testcasesupport.IO;

public class CWE568_Finalize_Without_Super__from_console_01_bad extends AbstractTestCaseClassIssueBad 
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
    
    public class BadClass extends HelperClass 
    { 
        protected void finalize() 
        {
            /* FLAW: missing super.finalize in this overridden method will cause a memory leak 
             * when the GC attempts to perform cleanup. */
            IO.writeLine("finalizing BadClass");
        }
    }
    
    public void bad() throws Throwable 
    {
        BadClass objectBad = new BadClass();
        try
        {
            objectBad.printMessage();
        }
        /* Ignore catching exceptions as we're only worried about the finally block */        
        finally 
        {
            /* cleanup */
            objectBad = null;
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
