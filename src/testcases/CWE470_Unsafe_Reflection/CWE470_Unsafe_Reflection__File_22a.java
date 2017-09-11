/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__File_22a.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-22a.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__File_22a extends AbstractTestCase
{
    /* The public static variable below is used to drive control flow in the source function.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean badPublicStatic = false;

    public void bad() throws Throwable
    {
        String data;

        badPublicStatic = true;
        data = (new CWE470_Unsafe_Reflection__File_22b()).badSource();

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    /* The public static variables below are used to drive control flow in the source functions.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodG2B1PublicStatic = false;
    public static boolean goodG2B2PublicStatic = false;

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    private void goodG2B1() throws Throwable
    {
        String data;

        goodG2B1PublicStatic = false;
        data = (new CWE470_Unsafe_Reflection__File_22b()).goodG2B1Source();

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    private void goodG2B2() throws Throwable
    {
        String data;

        goodG2B2PublicStatic = true;
        data = (new CWE470_Unsafe_Reflection__File_22b()).goodG2B2Source();

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> tempClass = Class.forName(data);
        Object tempClassObject = tempClass.newInstance();

        IO.writeLine(tempClassObject.toString()); /* Use tempClassObject in some way */

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
