/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_72b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-72b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: passwordAuth
 *    BadSink : data used as password in PasswordAuthentication()
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;
import java.util.Vector;

import java.util.logging.Level;
import java.io.*;

import java.net.PasswordAuthentication;

public class CWE259_Hard_Coded_Password__passwordAuth_72b
{
    public void badSink(Vector<String> dataVector ) throws Throwable
    {
        String data = dataVector.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", data.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Vector<String> dataVector ) throws Throwable
    {
        String data = dataVector.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication credentials = new PasswordAuthentication("user", data.toCharArray());
            IO.writeLine(credentials.toString());
        }

    }
}
