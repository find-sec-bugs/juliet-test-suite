/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__reader_16.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: reader
*    GoodSink: Report and rethrow FileNotFoundException
*    BadSink : Catch FileNotFoundException, but don't do anything about it
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Level;

public class CWE390_Error_Without_Action__reader_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            File file = null;
            FileInputStream streamFileInput = null;
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                file = new File("C:\\doesntexistandneverwill.txt");
            }
            else
            {
                /* running on non-Windows */
                file = new File("/home/user/doesntexistandneverwill.txt");
            }
            try
            {
                streamFileInput = new FileInputStream(file);
                readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
            }
            catch (FileNotFoundException exceptFileNotFound)
            {
                /* FLAW: do nothing if the file doesn't exist */
            }
            finally
            {
                /* Close stream reading objects */
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

                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            File file = null;
            FileInputStream streamFileInput = null;
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                file = new File("C:\\doesntexistandneverwill.txt");
            }
            else
            {
                /* running on non-Windows */
                file = new File("/home/user/doesntexistandneverwill.txt");
            }
            try
            {
                streamFileInput = new FileInputStream(file);
                readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
            }
            catch (FileNotFoundException exceptFileNotFound)
            {
                /* FIX: report read failure and rethrow */
                IO.writeLine("Error reading path: " + exceptFileNotFound.getMessage());
                throw exceptFileNotFound;
            }
            finally
            {
                /* Close stream reading objects */
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

                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
            break;
        }
    }

    public void good() throws Throwable
    {
        good1();
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
