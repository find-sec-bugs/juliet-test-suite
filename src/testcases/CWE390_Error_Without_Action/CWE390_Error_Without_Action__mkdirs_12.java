/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__mkdirs_12.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: mkdirs
*    GoodSink: Throw Exception if newDirectory cannot be created
*    BadSink : Do nothing if newDirectory cannot be created
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import java.io.File;

public class CWE390_Error_Without_Action__mkdirs_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
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
        }
        else
        {

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

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
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
        }
        else
        {

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
