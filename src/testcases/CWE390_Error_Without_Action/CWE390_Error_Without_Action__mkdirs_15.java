/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__mkdirs_15.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: mkdirs
*    GoodSink: Throw Exception if newDirectory cannot be created
*    BadSink : Do nothing if newDirectory cannot be created
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import java.io.File;

public class CWE390_Error_Without_Action__mkdirs_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        switch (7)
        {
        case 7:
            File newDirectory = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                newDirectory = new File("C:\\lvl_1\\lvl_2\\lvl_3\\");
            }
            else
            {
                /* running on non-Windows */
                newDirectory = new File("/home/user/lvl_1/lvl_2/lvl_3/");
            }
            if (!newDirectory.mkdirs())
            {
                /* FLAW: do nothing if newDirectory cannot be created */
            }
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch (8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        default:
            File newDirectory = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                newDirectory = new File("C:\\lvl_1\\lvl_2\\lvl_3\\");
            }
            else
            {
                /* running on non-Windows */
                newDirectory = new File("/home/user/lvl_1/lvl_2/lvl_3/");
            }
            if (!newDirectory.mkdirs())
            {
                /* FIX: report the mkdirs failure and throw a new Exception */
                IO.writeLine("The directories could not be created");
                StringBuilder errorString = new StringBuilder();
                errorString.append("The directories (");
                errorString.append(newDirectory.getAbsolutePath());
                errorString.append(") could not be created: ");
                throw new Exception(errorString.toString());
            }
            break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch (7)
        {
        case 7:
            File newDirectory = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                newDirectory = new File("C:\\lvl_1\\lvl_2\\lvl_3\\");
            }
            else
            {
                /* running on non-Windows */
                newDirectory = new File("/home/user/lvl_1/lvl_2/lvl_3/");
            }
            if (!newDirectory.mkdirs())
            {
                /* FIX: report the mkdirs failure and throw a new Exception */
                IO.writeLine("The directories could not be created");
                StringBuilder errorString = new StringBuilder();
                errorString.append("The directories (");
                errorString.append(newDirectory.getAbsolutePath());
                errorString.append(") could not be created: ");
                throw new Exception(errorString.toString());
            }
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
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
