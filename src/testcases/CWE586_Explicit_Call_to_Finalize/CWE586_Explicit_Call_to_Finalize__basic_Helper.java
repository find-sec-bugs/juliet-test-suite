/*
 * @description A helper class for CWE586_Explicit_Call_to_Finalize*.java
 * 
 * */
 
package testcases.CWE586_Explicit_Call_to_Finalize;

import java.util.logging.Level;

import testcasesupport.IO;

public class CWE586_Explicit_Call_to_Finalize__basic_Helper 
{
    /* The finalize method of built-in Java objects are hidden, so a 
     * custom object is used instead. Alternative to extend an object 
     * like FileInputStream and invoke the finalize() method from within
     * by overriding the close() method. e.g. super.finalize()
     */
    private String stringHelloWorld;
    
    public CWE586_Explicit_Call_to_Finalize__basic_Helper() 
    {
        this.stringHelloWorld = new String("hello world");
    }
    
    public void sayHello() 
    {
        IO.writeLine(this.stringHelloWorld);
    }
    
    protected void finalize() 
    {
        try
        {
            super.finalize();
        }
        catch(Throwable exceptThrowable)
        {
            IO.logger.log(Level.WARNING, "Error finalizing", exceptThrowable);
        }
        
        IO.writeLine("finalizing TestObject");
    }
}
