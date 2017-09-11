/*
 * @description The bad case doesn't perform a deep copy, so the caller can modify 
 * the value inside the class. The caller should not be able to do this since its 
 * marked final static.
 * 
 * */

package testcases.CWE607_Public_Static_Final_Mutable;

import java.util.Calendar;
import java.util.Date;

import testcasesupport.*;

public class CWE607_Public_Static_Final_Mutable__console_01_good1 extends AbstractTestCaseClassIssueGood 
{
    private final static Date date = new Date(); /* FIX: Make the mutable final static object private */
    
    public String getHello()
    {
        return "Hello!" + date.getTime();
    }
    
    public final Date getDate()
    {
        /* Do a deep copy */
        return (Date) date.clone(); 
    }

    public void good() 
    {
        IO.writeLine("Before: " + this.getHello());
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 01, 01);
        
        this.getDate().setTime(calendar.getTimeInMillis());
        
        IO.writeLine("After: " + this.getHello());
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
