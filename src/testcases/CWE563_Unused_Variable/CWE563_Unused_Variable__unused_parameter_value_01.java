/*
 * @description Unused method parameter value
 *
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_parameter_value_01 extends AbstractTestCase 
{
    private void helperBad(int intBad) 
    {
        /* FLAW: Overwrite the initial value of the parameter variable before use */
        intBad = 0;
        IO.writeLine("" + intBad);
    }
    
    public void bad()
    {
        helperBad(5);
    }
    
    private void helperGood1(int intGood1) 
    {
        /* FIX: Do not overwrite the value of the parameter variable before use */
        IO.writeLine("" + intGood1);
    }
    
    private void good1() 
    {
        helperGood1(10);
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
