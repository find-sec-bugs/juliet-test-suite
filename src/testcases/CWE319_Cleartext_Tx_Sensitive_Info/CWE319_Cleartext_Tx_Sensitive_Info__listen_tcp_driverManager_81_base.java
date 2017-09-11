/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_81_base.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

public abstract class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_81_base
{
    public abstract void action(String password ) throws Throwable;
}
