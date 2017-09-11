/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_long_81_base.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 563 Unused Variable
 * BadSource:  Initialize data
 * Sinks:
 *    GoodSink: Use data
 *    BadSink : do nothing
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public abstract class CWE563_Unused_Variable__unused_init_variable_long_81_base
{
    public abstract void action(long data ) throws Throwable;
}
