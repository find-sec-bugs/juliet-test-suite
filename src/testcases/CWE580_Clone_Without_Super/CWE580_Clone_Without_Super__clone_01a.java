/*
 * @description A class defines clone() but does not call super.clone().
 * 
 * */

package testcases.CWE580_Clone_Without_Super;

import testcasesupport.*;

public class CWE580_Clone_Without_Super__clone_01a extends AbstractTestCaseClassIssue implements Cloneable
{
    /* initialize badObject (bad object) and good1Object (good1 object) */
    {
        badObject = new CWE580_Clone_Without_Super__clone_01_bad();
        good1Object = new CWE580_Clone_Without_Super__clone_01_good1();
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
