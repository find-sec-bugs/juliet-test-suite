/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__counter_14.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: counter
*    GoodSink: If counter reaches a certain value, print to the console
*    BadSink : If counter reaches a certain value, launch an executable
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

public class CWE511_Logic_Time_Bomb__counter_14 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticFive == 5)
        {
            int count = 0;
            do
            {
                /* FLAW: counter triggered backdoor */
                if (count == 20000)
                {
                    Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
                }
                count++;
            }
            while (count < Integer.MAX_VALUE);
        }
    }

    /* good1() changes IO.staticFive==5 to IO.staticFive!=5 */
    private void good1() throws Throwable
    {
        if (IO.staticFive != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            int count = 0;

            do
            {
                /* FIX: no backdoor exists */
                if (count == 20000)
                {
                    IO.writeLine("Sorry, your license has expired.  Please contact support.");
                }
                count++;
            }
            while (count < Integer.MAX_VALUE);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (IO.staticFive == 5)
        {
            int count = 0;
            do
            {
                /* FIX: no backdoor exists */
                if (count == 20000)
                {
                    IO.writeLine("Sorry, your license has expired.  Please contact support.");
                }
                count++;
            }
            while (count < Integer.MAX_VALUE);
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
