/*
 * @description Infinite loop - for()
 *
 * */

package testcases.CWE835_Infinite_Loop;

import testcasesupport.*;

public class CWE835_Infinite_Loop__for_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: Infinite Loop - for() with no break point */
        for (int i = 0; i >= 0; i = (i + 1) % 256)
        {
            IO.writeLine(i);
        }
    }
    
    private void good1() 
    {
        for (int i = 0; i >= 0; i = (i + 1) % 256)
        {
            /* FIX: Add a break point for the loop if i = 10 */
            if (i == 10) 
            { 
                break; 
            }
            IO.writeLine(i);
        }
    }
    
    private void good2() 
    {
        /* FIX: Add a break point for the loop if i = 10 */
        for (int i = 0; i < 11; i = (i + 1) % 256)
        {
            IO.writeLine(i);
        }
    }
    
    public void good()  
    {
        good1();
        good2();
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
