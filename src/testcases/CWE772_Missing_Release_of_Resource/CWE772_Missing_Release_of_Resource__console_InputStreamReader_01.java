/*
 * @description Missing Release of Resource After Effective Lifetime.  Performs some, but not all, necessary resource cleanup (InputStreamReader is not closed).
 * 
 * */

package testcases.CWE772_Missing_Release_of_Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE772_Missing_Release_of_Resource__console_InputStreamReader_01 extends AbstractTestCase 
{    
    public void bad()
    {
        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;
        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            String readString = readerBuffered.readLine();
            
            IO.writeLine(readString);
        }
        catch (UnsupportedEncodingException exceptUnsupportedEncoding)
        {
            IO.logger.log(Level.WARNING, "Encoding is not supported!", exceptUnsupportedEncoding);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        
        /* FLAW: Streams are not closed */
    }
    
    private void good1() 
    {        
        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;
        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            String readString = readerBuffered.readLine();
            
            IO.writeLine(readString);
        }
        catch (UnsupportedEncodingException exceptUnsupportedEncoding)
        {
            IO.logger.log(Level.WARNING, "Encoding is not supported!", exceptUnsupportedEncoding);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        /* FIX: Streams closed appropriately */
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
            }

            try 
            {
                if (readerInputStream != null ) 
                {
                    readerInputStream.close();
                }
            }
            catch (IOException exceptIO) 
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
            }
        }
    }
    
    public void good() 
    {
        good1();
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
