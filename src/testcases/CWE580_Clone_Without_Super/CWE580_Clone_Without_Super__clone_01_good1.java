/*
 * @description A class defines clone() but does not call super.clone().
 * 
 * This is the "good" version, which has a clone() that does call super.clone().
 * 
 * */

package testcases.CWE580_Clone_Without_Super;

import java.util.Date;
import testcasesupport.*;

public class CWE580_Clone_Without_Super__clone_01_good1 extends AbstractTestCaseClassIssueGood implements Cloneable
{
    /* Just to have something to do in clone() other than return the object */
    private Date theDate = new Date();

    public void setDate(Date theDate) 
    {
        this.theDate = (Date) theDate.clone();
    }
        
    protected final Object clone() throws CloneNotSupportedException 
    {
        /* FIX: super.clone() is called */
        CWE580_Clone_Without_Super__clone_01_good1 objectGood1 = (CWE580_Clone_Without_Super__clone_01_good1) super.clone();          
        objectGood1.setDate(new Date(theDate.getTime()));
        return objectGood1;
    }
    
    public void good1() throws CloneNotSupportedException
    { 
        /* Use the clone method */
        CWE580_Clone_Without_Super__clone_01_good1 myClone = (CWE580_Clone_Without_Super__clone_01_good1)clone();

        myClone.setDate(new Date());
    }
    
    public void good() throws CloneNotSupportedException
    {
        good1();
    }
}
