/*
 * @description Missing Release of File Descriptor or Handle After Effective Lifetime.  Performs some, but not all, necessary resource cleanup (BufferedReader is not closed).
 * 
 * */

package testcases.CWE775_Missing_Release_of_File_Descriptor_or_Handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE775_Missing_Release_of_File_Descriptor_or_Handle__FileReader_01 extends AbstractTestCase 
{    
    public void bad()
    {
        BufferedReader readerBuffered = null;
        FileReader readerFile = null;
        try
        {
            File file = new File("c:\\file.txt");
            readerFile = new FileReader(file);
            readerBuffered = new BufferedReader(readerFile);
            String readString = readerBuffered.readLine();
            
            IO.writeLine(readString);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        /* FLAW: file, readerFile, and readerBuffered not closed */
    }
    
    private void good1()
    {        
        BufferedReader readerBuffered = null;
        FileReader readerFile = null;
        try
        {
            File file = new File("c:\\file.txt");
            readerFile = new FileReader(file);
            readerBuffered = new BufferedReader(readerFile);
            String readString = readerBuffered.readLine();
            
            IO.writeLine(readString);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        finally
        {
            try 
            {
                if (readerFile != null) 
                {
                    readerFile.close();
                }
            }
            catch (IOException exceptIO) 
            {
                IO.logger.log(Level.WARNING, "Error closing FileReader", exceptIO);
            }
            
            /* FIX: BufferedReader closed appropriately */
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
        }
    }
    
    public void good() throws IOException 
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
