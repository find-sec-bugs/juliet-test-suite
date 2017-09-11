/*
 * @description Embedded Malicious Code. Abuse of reflection by modifying a public static final variable
 * 
 * */

package testcases.CWE506_Embedded_Malicious_Code;

import java.lang.reflect.Field;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

/* Inspired by slide 25 in https://www.owasp.org/images/8/8f/OWASPBeNeLux2010-Madou-RepellingTheWilyInsider.pdf */

public class CWE506_Embedded_Malicious_Code__reflection_01 extends AbstractTestCase
{    
    public static final String READONLY_VARIABLE = "Please don't modify me";
    
    public void bad() throws NoSuchFieldException, IllegalAccessException
    {
        /* FLAW: Use reflection to modify a variable declared final */
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(READONLY_VARIABLE, "Sorry, but I've changed.".toCharArray());
        
        IO.writeLine(READONLY_VARIABLE);
    }
    
    private void good1() 
    {        
        /* FIX: Use, but do not attempt to change a final variable */
        IO.writeLine(READONLY_VARIABLE);
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
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException 
    {
        mainFromParent(args);
    }
}
