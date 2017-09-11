/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Environment_executeUpdate_81_base.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: executeUpdate
 *    GoodSink: Use prepared statement and executeUpdate (properly)
 *    BadSink : data concatenated into SQL statement used in executeUpdate(), which could result in SQL Injection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE89_SQL_Injection.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE89_SQL_Injection__Environment_executeUpdate_81_base
{
    public abstract void action(String data ) throws Throwable;
}
