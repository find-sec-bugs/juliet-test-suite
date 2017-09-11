/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_File_66b.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: File Read count from file (named c:\data.txt)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_File_66b
{
    public void badSink(int countArray[] ) throws Throwable
    {
        int count = countArray[2];

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int countArray[] ) throws Throwable
    {
        int count = countArray[2];

        /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
        Thread.sleep(count);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int countArray[] ) throws Throwable
    {
        int count = countArray[2];

        /* FIX: Validate count before using it in a call to Thread.sleep() */
        if (count > 0 && count <= 2000)
        {
            Thread.sleep(count);
        }

    }
}
