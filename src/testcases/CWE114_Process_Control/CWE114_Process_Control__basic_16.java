/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE114_Process_Control__basic_16.java
Label Definition File: CWE114_Process_Control__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 114 Process Control
* Sinks:
*    GoodSink: use System.load() to load a library
*    BadSink : use System.loadLibrary() to load a library
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE114_Process_Control;

import testcasesupport.*;

public class CWE114_Process_Control__basic_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            String libraryName = "test.dll";
            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libraryName);
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            String root;
            String libraryName = "test.dll";
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                root = "C:\\libs\\";
            }
            else
            {
                /* running on non-Windows */
                root = "/home/user/libs/";
            }
            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libraryName);
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
