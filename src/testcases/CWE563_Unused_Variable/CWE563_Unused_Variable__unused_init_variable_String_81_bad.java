/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_String_81_bad.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-81_bad.tmpl.java
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

public class CWE563_Unused_Variable__unused_init_variable_String_81_bad extends CWE563_Unused_Variable__unused_init_variable_String_81_base
{
    public void action(String data ) throws Throwable
    {

        /* FLAW: Do not use the variable */
        /* do nothing */
        ; /* empty statement needed for some flow variants */

    }
}
