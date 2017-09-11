/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE526_Info_Exposure_Environment_Variables__writeLine_16.java
Label Definition File: CWE526_Info_Exposure_Environment_Variables.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 526 Information Exposure Through Environment Variables
* Sinks: writeLine
*    GoodSink: no exposing
*    BadSink : expose the path variable to the user
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE526_Info_Exposure_Environment_Variables;

import testcasesupport.*;

public class CWE526_Info_Exposure_Environment_Variables__writeLine_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            /* FLAW: environment variable information exposed */
            IO.writeLine("Not in path: " + System.getenv("PATH"));
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            /* FIX: error message is general */
            IO.writeLine("Not in path");
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
