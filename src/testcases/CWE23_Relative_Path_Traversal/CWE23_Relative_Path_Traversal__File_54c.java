/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__File_54c.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-54c.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__File_54c
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__File_54d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__File_54d()).goodG2BSink(data );
    }
}
