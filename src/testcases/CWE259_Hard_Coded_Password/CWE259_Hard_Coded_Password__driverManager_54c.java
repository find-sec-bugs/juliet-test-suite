/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_54c.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-54c.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: driverManager
 *    BadSink : data used as password in database connection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.util.logging.Level;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_54c
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__driverManager_54d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__driverManager_54d()).goodG2BSink(data );
    }
}
