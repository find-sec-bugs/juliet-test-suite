/*
 * @description An object contains sensitive data and is serializable
 *  
 * This helper class implements Serializable so that any class that inherits
 * from it also implements Serializable
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.io.*;
import testcasesupport.*;
 
public class CWE499_Sensitive_Data_Serializable__serializable_Helper extends AbstractTestCaseClassIssue implements Serializable
{
	private static final long serialVersionUID = 100000L;
	
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
