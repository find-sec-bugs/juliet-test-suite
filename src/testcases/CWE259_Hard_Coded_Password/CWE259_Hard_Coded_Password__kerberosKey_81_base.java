/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__kerberosKey_81_base.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: kerberosKey
 *    BadSink : data used as password in KerberosKey()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.util.logging.Level;
import java.io.*;

public abstract class CWE259_Hard_Coded_Password__kerberosKey_81_base
{
    public abstract void action(String data ) throws Throwable;
}
