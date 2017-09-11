/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__connect_tcp_HashSet_81_bad.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashSet
 *    BadSink : Create a HashSet using data as the initial size
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.HashSet;

public class CWE789_Uncontrolled_Mem_Alloc__connect_tcp_HashSet_81_bad extends CWE789_Uncontrolled_Mem_Alloc__connect_tcp_HashSet_81_base
{
    public void action(int data ) throws Throwable
    {

        /* POTENTIAL FLAW: Create a HashSet using data as the initial size.  data may be very large, creating memory issues */
        HashSet intHashSet = new HashSet(data);

    }
}
