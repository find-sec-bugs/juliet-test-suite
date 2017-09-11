/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_68b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * BadSink: passwordAuth data used as password in PasswordAuthentication()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.util.logging.Level;
import java.io.*;

import java.net.PasswordAuthentication;

public class CWE259_Hard_Coded_Password__passwordAuth_68b
{
    public void badSink() throws Throwable
    {
        String data = CWE259_Hard_Coded_Password__passwordAuth_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", data.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        String data = CWE259_Hard_Coded_Password__passwordAuth_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", data.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }
}
