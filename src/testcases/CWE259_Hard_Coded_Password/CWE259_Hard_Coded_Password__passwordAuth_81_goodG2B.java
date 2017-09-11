/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_81_goodG2B.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: passwordAuth
 *    BadSink : data used as password in PasswordAuthentication()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.util.logging.Level;
import java.io.*;

import java.net.PasswordAuthentication;

public class CWE259_Hard_Coded_Password__passwordAuth_81_goodG2B extends CWE259_Hard_Coded_Password__passwordAuth_81_base
{
    public void action(String data ) throws Throwable
    {

        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", data.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }
}
