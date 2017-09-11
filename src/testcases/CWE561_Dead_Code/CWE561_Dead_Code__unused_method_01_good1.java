/*
 * @description Bad class never uses the private function calculation, therefore, it is dead code.
 * 
 * */
package testcases.CWE561_Dead_Code;

import testcasesupport.AbstractTestCaseClassIssueGood;
import testcasesupport.IO;

public class CWE561_Dead_Code__unused_method_01_good1 extends AbstractTestCaseClassIssueGood 
{
    /* FIX: good() method calls calculation() */
    private String calculation()
    {
        return "Calculation";
    }
    
    public void good() throws Throwable 
    {
        good1();
    }
    
    private void good1()
    {
        IO.writeLine(calculation());
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
