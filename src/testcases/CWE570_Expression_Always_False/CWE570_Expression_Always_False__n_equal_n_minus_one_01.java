/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;

public class CWE570_Expression_Always_False__n_equal_n_minus_one_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to false */
        int intThirty = 30;

        if (intThirty == (intThirty - 1))
        {
            IO.writeLine("never prints");
        }
    }
    
    public void good()
    {
        good1();
    }
    
    private void good1()
    {
        int intSecureRandom1 = (new SecureRandom()).nextInt();
        int intSecureRandom2 = (new SecureRandom()).nextInt();
        /* FIX: may evaluate to true or false */
        if (intSecureRandom1 != intSecureRandom2)
        {
            IO.writeLine("sometimes prints");
        }
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
