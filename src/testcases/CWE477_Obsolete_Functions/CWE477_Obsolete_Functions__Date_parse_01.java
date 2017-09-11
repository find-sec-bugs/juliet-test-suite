/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__Date_parse_01.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: Date_parse
*    GoodSink: Use of preferred java.text.DateFormat.parse(String)
*    BadSink : Use of deprecated java.util.Date.parse(String) method
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__Date_parse_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: Use of deprecated Date.parse(String) method */
        long unixDate = java.util.Date.parse("2010-07-13 10:41:00");

        IO.writeLine(unixDate); /* Use unixDate */

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        /* FIX: Use preferred DateFormat.parse(String) method */
        java.util.Date date = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");

        IO.writeLine(date.toString()); /* Use date */

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

