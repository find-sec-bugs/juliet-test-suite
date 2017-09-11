/*
 * @description A class defines clone() but does not call super.clone().
 * 
 * This is the "bad" version, which has a clone() that does not
 * call super.clone().
 * 
 * */

 package testcases.CWE580_Clone_Without_Super;

import java.util.Date;
import testcasesupport.*;

public class CWE580_Clone_Without_Super__clone_01_bad extends AbstractTestCaseClassIssueBad implements Cloneable
{
    /* Just to have something to do in clone() other than return the object */
    private Date theDate = new Date();

    public void setDate(Date theDate) 
    {
        this.theDate = (Date) theDate.clone();
    }
        
    protected final Object clone() throws CloneNotSupportedException 
    {
        /* FLAW: super.clone() is not called */
        CWE580_Clone_Without_Super__clone_01_bad objectBad = new CWE580_Clone_Without_Super__clone_01_bad();     
        objectBad.setDate(new Date(theDate.getTime()));
        return objectBad;
    }
    
    public void bad() throws CloneNotSupportedException
    { 
        /* Use the clone method */
        CWE580_Clone_Without_Super__clone_01_bad myClone = (CWE580_Clone_Without_Super__clone_01_bad)clone();

        myClone.setDate(new Date());
    }
}
