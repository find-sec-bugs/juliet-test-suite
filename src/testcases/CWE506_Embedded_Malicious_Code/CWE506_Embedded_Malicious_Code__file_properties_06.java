/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__file_properties_06.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-06.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: file_properties
*    GoodSink: Do not modify any file properties
*    BadSink : Alter file property Last Modified
* Flow Variant: 06 Control flow: if(PRIVATE_STATIC_FINAL_FIVE==5) and if(PRIVATE_STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE506_Embedded_Malicious_Code__file_properties_06 extends AbstractTestCase
{
    /* The variable below is declared "final", so a tool should be able
     * to identify that reads of this will always give its initialized
     * value.
     */
    private static final int PRIVATE_STATIC_FINAL_FIVE = 5;

    public void bad() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE == 5)
        {
            FileOutputStream streamFileOutput = null;
            try
            {
                String path = "C:\\test_bad.txt";
                File file = new File(path);
                long lastModified = file.lastModified();
                streamFileOutput = new FileOutputStream(file);
                streamFileOutput.write("This is a new line".getBytes("UTF-8"));
                /* INCIDENTAL: CWE 252 - Unchecked Return Value - some tools report
                 * an unchecked return value from setLastModified, but this is intentional as
                 * this method call is supposed to be "hidden" in the code
                 */
                /* FLAW: altering file properties */
                file.setLastModified(lastModified - 10000L);
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "File I/O error", exceptIO);
            }
            finally
            {
                try
                {
                    if (streamFileOutput != null)
                    {
                        streamFileOutput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
                }
            }
        }
    }

    /* good1() changes PRIVATE_STATIC_FINAL_FIVE==5 to PRIVATE_STATIC_FINAL_FIVE!=5 */
    private void good1() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            FileOutputStream streamFileOutput = null;

            try
            {
                String path = "C:\\test_good.txt";
                File file = new File(path);
                streamFileOutput = new FileOutputStream(file);
                streamFileOutput.write("This is a new line".getBytes("UTF-8"));
                /* FIX: Not altering file properties */
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "File I/O error", exceptIO);
            }
            finally
            {
                try
                {
                    if (streamFileOutput != null)
                    {
                        streamFileOutput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
                }
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE == 5)
        {
            FileOutputStream streamFileOutput = null;
            try
            {
                String path = "C:\\test_good.txt";
                File file = new File(path);
                streamFileOutput = new FileOutputStream(file);
                streamFileOutput.write("This is a new line".getBytes("UTF-8"));
                /* FIX: Not altering file properties */
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "File I/O error", exceptIO);
            }
            finally
            {
                try
                {
                    if (streamFileOutput != null)
                    {
                        streamFileOutput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
                }
            }
        }
    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
