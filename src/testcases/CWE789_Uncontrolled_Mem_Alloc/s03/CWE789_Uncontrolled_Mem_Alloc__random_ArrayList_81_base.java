/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__random_ArrayList_81_base.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: ArrayList
 *    BadSink : Create an ArrayList using data as the initial size
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s03;
import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE789_Uncontrolled_Mem_Alloc__random_ArrayList_81_base
{
    public abstract void action(int data ) throws Throwable;
}
