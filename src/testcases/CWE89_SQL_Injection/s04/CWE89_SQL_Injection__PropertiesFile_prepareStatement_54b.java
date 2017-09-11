/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__PropertiesFile_prepareStatement_54b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: prepareStatement
 *    GoodSink: Use prepared statement and execute (properly)
 *    BadSink : data concatenated into SQL statement used in prepareStatement() call, which could result in SQL Injection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE89_SQL_Injection__PropertiesFile_prepareStatement_54b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__PropertiesFile_prepareStatement_54c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__PropertiesFile_prepareStatement_54c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__PropertiesFile_prepareStatement_54c()).goodB2GSink(data );
    }
}
