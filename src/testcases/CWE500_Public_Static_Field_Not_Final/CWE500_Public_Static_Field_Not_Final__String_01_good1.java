/*
 * @description Public static fields should be marked final.  If they are not, they
 * may be manipulated in unexpected ways.
 *  
 * This class contains the "good" version.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE500_Public_Static_Field_Not_Final;

import testcasesupport.*;

public class CWE500_Public_Static_Field_Not_Final__String_01_good1 extends AbstractTestCaseClassIssueGood implements Cloneable 
{    
    /* FIX: public static field marked final */
    public static final String DEFAULT_ERROR = "The value you entered was not understood.  Please try again.";
    
    private void good1() 
    { 
        IO.writeLine(DEFAULT_ERROR);
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
