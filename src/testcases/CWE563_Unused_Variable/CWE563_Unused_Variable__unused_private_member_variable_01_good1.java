/*
 * @description Unused private class member variable
 * 
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_private_member_variable_01_good1 extends AbstractTestCaseClassIssueGood 
{
    private int intGood1 = 1;

    private void good1() 
    { 
        /* FIX: Use intGood1 */
        IO.writeLine("" + intGood1);
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
