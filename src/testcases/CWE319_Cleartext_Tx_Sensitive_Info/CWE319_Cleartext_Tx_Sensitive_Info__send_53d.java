/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_53d.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-53d.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;

import java.net.*;
import java.util.logging.Level;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_53d
{
    public void badSink(String data ) throws Throwable
    {

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
    public void goodG2BSink(String data ) throws Throwable
    {

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
    public void goodB2GSink(String data ) throws Throwable
    {

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
}
