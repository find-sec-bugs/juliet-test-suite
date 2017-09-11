/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__URLConnection_prepareStatement_81_base.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: prepareStatement
 *    GoodSink: Use prepared statement and execute (properly)
 *    BadSink : data concatenated into SQL statement used in prepareStatement() call, which could result in SQL Injection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE89_SQL_Injection.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public abstract class CWE89_SQL_Injection__URLConnection_prepareStatement_81_base
{
    public abstract void action(String data ) throws Throwable;
}
