/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__Property_53b.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: Property Read data from a system property
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__Property_53b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE606_Unchecked_Loop_Condition__Property_53c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE606_Unchecked_Loop_Condition__Property_53c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE606_Unchecked_Loop_Condition__Property_53c()).goodB2GSink(data );
    }
}
