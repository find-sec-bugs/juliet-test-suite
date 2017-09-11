/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__Date_parse_03.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: Date_parse
*    GoodSink: Use of preferred java.text.DateFormat.parse(String)
*    BadSink : Use of deprecated java.util.Date.parse(String) method
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__Date_parse_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (5 == 5)
        {
            /* FLAW: Use of deprecated Date.parse(String) method */
            long unixDate = java.util.Date.parse("2010-07-13 10:41:00");
            IO.writeLine(unixDate); /* Use unixDate */
        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if (5 != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Use preferred DateFormat.parse(String) method */
            java.util.Date date = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");

            IO.writeLine(date.toString()); /* Use date */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (5 == 5)
        {
            /* FIX: Use preferred DateFormat.parse(String) method */
            java.util.Date date = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");
            IO.writeLine(date.toString()); /* Use date */
        }
    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
