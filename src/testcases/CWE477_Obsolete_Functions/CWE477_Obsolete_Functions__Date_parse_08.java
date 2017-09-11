/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__Date_parse_08.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: Date_parse
*    GoodSink: Use of preferred java.text.DateFormat.parse(String)
*    BadSink : Use of deprecated java.util.Date.parse(String) method
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__Date_parse_08 extends AbstractTestCase
{
    /* The methods below always return the same value, so a tool
     * should be able to figure out that every call to these
     * methods will return true or return false.
     */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (privateReturnsTrue())
        {
            /* FLAW: Use of deprecated Date.parse(String) method */
            long unixDate = java.util.Date.parse("2010-07-13 10:41:00");
            IO.writeLine(unixDate); /* Use unixDate */
        }
    }

    /* good1() changes privateReturnsTrue() to privateReturnsFalse() */
    private void good1() throws Throwable
    {
        if (privateReturnsFalse())
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
        if (privateReturnsTrue())
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
