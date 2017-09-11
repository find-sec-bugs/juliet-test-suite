/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__Environment_81a.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-81a.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__Environment_81a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        CWE23_Relative_Path_Traversal__Environment_81_base baseObject = new CWE23_Relative_Path_Traversal__Environment_81_bad();
        baseObject.action(data );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        CWE23_Relative_Path_Traversal__Environment_81_base baseObject = new CWE23_Relative_Path_Traversal__Environment_81_goodG2B();
        baseObject.action(data );
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
