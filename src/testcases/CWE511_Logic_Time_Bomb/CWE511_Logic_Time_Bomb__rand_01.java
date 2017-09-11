/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__rand_01.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: rand
*    GoodSink: If specific random number generated, print to the console
*    BadSink : If specific random number generated, launch an executable
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE511_Logic_Time_Bomb__rand_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: PRNG triggered backdoor */
        if ((new SecureRandom()).nextInt() == 20000)
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

        /* FIX: no backdoor exists */
        if ((new SecureRandom()).nextInt() == 20000)
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

