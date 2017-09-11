/*
 * @description Throw an overly-broad exception (in this case, Throwable).  This is a manual test case because generated test cases are all in methods that throw Throwable and we want to avoid that since it is related to this CWE.
 *
 * */

package testcases.CWE397_Throw_Generic;

import testcasesupport.AbstractTestCase;
import java.io.FileNotFoundException;

public class CWE397_Throw_Generic__throw_Exception_01 extends AbstractTestCase 
{
    public void bad() throws Exception 
    {
        throw new Exception(); /* FLAW: Throw Exception, which is very generic */ 
    }

    private void good1() throws FileNotFoundException
    {
        throw new FileNotFoundException(); /* FIX: Throw specific exception (FileNotFoundException) */ 
    }

    public void good() throws FileNotFoundException
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
