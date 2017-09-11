/*
 * @description A user function in this helper class returns null.  Calling methods should 
 *   be checking returned values against null.
 * 
 * */

package testcases.CWE690_NULL_Deref_From_Return;

public class CWE690_NULL_Deref_From_Return__Class_Helper 
{
    static String getStringBad() 
    {
        return null;    
    }
    
    static String getStringGood() 
    {
        return "getStringGood";    
    }
    
    static StringBuilder getStringBuilderBad() 
    {
        return null;
    }
    
    static StringBuilder getStringBuilderGood()
    {
        return new StringBuilder("getStringBuilderGood");
    }
}
