/*
 * @description 
 * Java code makes a call into a potentially unsafe unmanaged DLL.
 * The bad case allows the user to specify the length of the input string.
 * In addition, the case does not recognize the limitations of the unmanaged
 * code and does no input validation.
 * 
 * In order to get this to run, you need to place the JNITest.dll (Windows)
 * or libJNITest (Linux) in your Java library path.
 * 
 * */

package testcases.CWE111_Unsafe_JNI;

import testcasesupport.AbstractTestCaseBadOnly;
import testcasesupport.IO;
import java.io.*;

import java.util.logging.Level;

public class CWE111_Unsafe_JNI__console_01 extends AbstractTestCaseBadOnly 
{
    native String test(String s1, int len);
    
    static 
    {
        try
        {
            System.loadLibrary("JNITest"); /* load JNITest.dll or libJNITest.so */
        }
        catch (UnsatisfiedLinkError errorUnsatisfiedLink)
        {
            IO.logger.log(Level.WARNING, "Error, the library does not exist", errorUnsatisfiedLink);
        }
    }
    
    public void bad() throws IOException 
    {
        InputStreamReader readerInputStream = null;
        BufferedReader readerBuffered = null;

        int intNumber = 0;
        try
        {
            IO.writeLine("Enter a string: (asdf)" );

            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            
            String stringLine = readerBuffered.readLine();
            
            IO.writeLine("How long was your string? (200) ");
            intNumber = Integer.parseInt(readerBuffered.readLine());
        
            IO.writeLine("Result from native method: " + test(stringLine, intNumber)); /* FLAW: Using an unsafe JNI method */
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            return;
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
            }
        }
    }
    
    /* Below is the main(). It is only used when building this testcase on 
     * its own for testing or for building a binary to use in testing binary 
     * analysis tools. It is not used when compiling all the testcases as one 
     * application, which is how source code analysis tools are tested. 
	 */ 
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException 
    {
        mainFromParent(args);
    }
}
