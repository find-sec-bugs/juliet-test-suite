/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__time_01.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: time
*    GoodSink: after a certain date, print to the console
*    BadSink : after a certain date, launch an executable
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.util.Calendar;

public class CWE511_Logic_Time_Bomb__time_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        Calendar calendarNow = Calendar.getInstance();

        Calendar calendarCheck = Calendar.getInstance();
        calendarCheck.set(2020, 1, 1);

        /* FLAW: date triggered backdoor */
        if (calendarNow.after(calendarCheck))
        {
            Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        Calendar calendarNow = Calendar.getInstance();

        Calendar calendarCheck = Calendar.getInstance();
        calendarCheck.set(2020, 1, 1);

        /* FIX: no backdoor exists */
        if (calendarNow.after(calendarCheck))
        {
            IO.writeLine("Sorry, your license has expired.  Please contact support.");
        }

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

