/*
 * @description Public static fields should be marked final.  If they are not, they
 * may be manipulated in unexpected ways.
 *  
 * This class contains the "bad" version.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE500_Public_Static_Field_Not_Final;

import testcasesupport.*;

public class CWE500_Public_Static_Field_Not_Final__String_01_bad extends AbstractTestCaseClassIssueBad implements Cloneable 
{
    /* FLAW: public static fields should be marked final */
    public static String DEFAULT_ERROR = "The value you entered was not understood.  Please try again.";
    
    public void bad() 
    {    
        IO.writeLine(DEFAULT_ERROR);
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
