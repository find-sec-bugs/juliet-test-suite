/*
 * @description call an empty function
 * 
 * */
package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__empty_function_01 extends AbstractTestCase 
{
    private void helperBad() 
    {
        /* FLAW: Function does nothing */
    }

    public void bad()
    {
        helperBad();
    }
    
    private void helperGood1() 
    {
        /* FIX: This function contains code */
        IO.writeLine("helperGood1()");
    }
    
    private void good1()
    {
        helperGood1();
    }
    
    public void good()
    {
        good1();
    }

    /* Below is the main(). It is only used when building this testcase on 
     * its own for testing or for building a binary to use in testing binary 
     * analysis tools. It is not used when compiling all the testcases as one 
     * application, which is how source code analysis tools are tested. 
	 */ 
    public static void main(String[] args) 
        throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        mainFromParent(args);
    }

}
