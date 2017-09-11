/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE570_Expression_Always_False__string_equals_01 extends AbstractTestCase 
{
    public void bad()
    {
        String stringFalse = "false";
        /* FLAW: always evaluates to false */
        if (stringFalse.equals("true"))
        {
            IO.writeLine("never prints");
        }
    }
    
    public void good()
    {
        good1();
    }
    
    private void good1()
    {
        String stringInput = "";
        IO.writeLine("Enter a string: ");
        boolean isError = false;
        
        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;
        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            stringInput = readerBuffered.readLine();
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        finally 
        {
            try 
            {
                if (readerBuffered != null) 
                {
                    readerBuffered.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                isError = true;
            }
            
            try 
            {
                if (readerInputStream != null) 
                {   
                    readerInputStream.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                isError = true;
            }
            
        }

		if (isError) 
        {
			return; 
        }
        
        /* FIX: may evaluate to true or false */
        if (stringInput.contentEquals("true"))
        {
            IO.writeLine("sometimes prints");
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
