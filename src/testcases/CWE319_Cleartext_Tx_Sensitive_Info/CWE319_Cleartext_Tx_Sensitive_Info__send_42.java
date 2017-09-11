/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_42.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;

import java.net.PasswordAuthentication;

import java.net.*;
import java.util.logging.Level;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_42 extends AbstractTestCase
{
    private String badSource() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication credentials = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(credentials.getPassword());

        return data;
    }

    public void bad() throws Throwable
    {
        String data = badSource();

        Socket socket = null;
        PrintWriter writer = null;

        try
        {
            socket = new Socket("remote_host", 1337);
            writer = new PrintWriter(socket.getOutputStream(), true);
            /* POTENTIAL FLAW: sending data over an unencrypted (non-SSL) channel */
            writer.println(data);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error writing to the socket", exceptIO);
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }

            try
            {
                if (socket != null)
                {
                    socket.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
            }
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private String goodG2BSource() throws Throwable
    {
        String data;

        /* FIX: Use a regular string (non-sensitive string) */
        data = "Hello World";

        return data;
    }

    private void goodG2B() throws Throwable
    {
        String data = goodG2BSource();

        Socket socket = null;
        PrintWriter writer = null;

        try
        {
            socket = new Socket("remote_host", 1337);
            writer = new PrintWriter(socket.getOutputStream(), true);
            /* POTENTIAL FLAW: sending data over an unencrypted (non-SSL) channel */
            writer.println(data);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error writing to the socket", exceptIO);
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }

            try
            {
                if (socket != null)
                {
                    socket.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private String goodB2GSource() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication credentials = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(credentials.getPassword());

        return data;
    }

    private void goodB2G() throws Throwable
    {
        String data = goodB2GSource();

        SSLSocketFactory sslsSocketFactory = null;
        SSLSocket sslSocket = null;
        PrintWriter writer = null;

        try
        {
            sslsSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            sslSocket = (SSLSocket) sslsSocketFactory.createSocket("remote_host", 1337);
            writer = new PrintWriter(sslSocket.getOutputStream(), true);
            /* FIX: sending data over an SSL encrypted channel */
            writer.println(data);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error writing to the socket", exceptIO);
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }

            try
            {
                if (sslSocket != null)
                {
                    sslSocket.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing SSLSocket", exceptIO);
            }
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
