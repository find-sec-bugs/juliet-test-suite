/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__kerberosKey_54d.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-54d.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: kerberosKey
 *    BadSink : data used as password in KerberosKey()
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.util.logging.Level;
import java.io.*;

public class CWE259_Hard_Coded_Password__kerberosKey_54d
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__kerberosKey_54e()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__kerberosKey_54e()).goodG2BSink(data );
    }
}
