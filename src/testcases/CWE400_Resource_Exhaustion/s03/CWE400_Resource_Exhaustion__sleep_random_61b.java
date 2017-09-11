/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_random_61b.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__sleep_random_61b
{
    public int badSource() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        count = (new SecureRandom()).nextInt();

        return count;
    }

    /* goodG2B() - use goodsource and badsink */
    public int goodG2BSource() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        return count;
    }

    /* goodB2G() - use badsource and goodsink */
    public int goodB2GSource() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        count = (new SecureRandom()).nextInt();

        return count;
    }
}
