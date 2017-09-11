/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_PropertiesFile_71b.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-71b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: PropertiesFile Read count from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_PropertiesFile_71b
{
    public void badSink(Object countObject ) throws Throwable
    {
        int count = (Integer)countObject;

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Object countObject ) throws Throwable
    {
        int count = (Integer)countObject;

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(Object countObject ) throws Throwable
    {
        int count = (Integer)countObject;

        /* FIX: Validate count before using it in a call to Thread.sleep() */
        if (count > 0 && count <= 2000)
        {
            Thread.sleep(count);
        }

    }
}
