/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE114_Process_Control__basic_11.java
Label Definition File: CWE114_Process_Control__basic.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 114 Process Control
* Sinks:
*    GoodSink: use System.load() to load a library
*    BadSink : use System.loadLibrary() to load a library
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE114_Process_Control;

import testcasesupport.*;

public class CWE114_Process_Control__basic_11 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrue())
        {
            String libraryName = "test.dll";
            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libraryName);
        }
    }

    /* good1() changes IO.staticReturnsTrue() to IO.staticReturnsFalse() */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
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

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (IO.staticReturnsTrue())
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
