/*
 * @description Unused public class member value
 * 
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_public_member_value_01_bad extends AbstractTestCaseClassIssueBad 
{
    public int intBad = 5; /* This value of intBad is never used */

    public void bad() 
    {    
        /* FLAW: Set intBad to a new value before using it */
        intBad = 10;
        IO.writeLine("" + intBad);
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
