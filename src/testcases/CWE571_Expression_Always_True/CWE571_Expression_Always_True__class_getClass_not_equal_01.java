/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;
import java.util.Random;

public class CWE571_Expression_Always_True__class_getClass_not_equal_01 extends AbstractTestCase
{    
    public void bad()
    {
        /* FLAW: always evaluates to true */
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();

        if (!random.getClass().equals(secureRandom.getClass()))
        {
            IO.writeLine("always prints");
        }
    }
    
    public void good()
    {
        good1();
    }
    
    private void good1()
    {
        Object objectArray[] = new Object [] {new Random(), new SecureRandom(), new SecureRandom()};
        
        int intSecureRandom = (new SecureRandom()).nextInt(3);
        
        /* FIX: may evaluate to true or false */
        if (objectArray[1].getClass().equals(objectArray[intSecureRandom].getClass()))
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
