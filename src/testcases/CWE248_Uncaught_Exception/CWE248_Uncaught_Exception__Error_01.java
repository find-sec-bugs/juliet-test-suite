/*
 * @description Explicitly throw an Error that will not be caught by any code and the JVM will halt.  Unfortunately the design of our test cases don't let us throw an Exception (runTest() in AbstractTestCase is not declared as throwing anything and adding a throw cascades to updates to all test case files).
 *
 * */

package testcases.CWE248_Uncaught_Exception;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.util.logging.Level;

public class CWE248_Uncaught_Exception__Error_01 extends AbstractTestCase 
{
    public void bad() 
    {
        /* FLAW: Error not caught */
        throw new Error("Really bad Error");
    }

    private void good1() 
    {
        /* FIX: Error caught */
        try
        {
            throw new Error("Really bad Error");
        }
        catch(Error error)
        {
            IO.logger.log(Level.WARNING, "Caught an Error", error);
        }
    }

    public void good() 
    {
        good1();
    } 

    /* Override runTest for this test case so that it doesn't catch the Error */
    public void runTest(String classname) 
    {
        IO.writeLine("Starting tests for Class " + classname);

        good();  
        IO.writeLine("Completed good() for Class " + classname);

        bad();
        IO.writeLine("Completed bad() for Class " + classname);
    } /* runTest */

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
