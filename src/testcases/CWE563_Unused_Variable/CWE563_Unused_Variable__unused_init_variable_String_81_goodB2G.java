/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_String_81_goodB2G.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-81_goodB2G.tmpl.java
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

public class CWE563_Unused_Variable__unused_init_variable_String_81_goodB2G extends CWE563_Unused_Variable__unused_init_variable_String_81_base
{
    public void action(String data ) throws Throwable
    {

        /* FIX: Use data */

        IO.writeLine(data);

    }
}
