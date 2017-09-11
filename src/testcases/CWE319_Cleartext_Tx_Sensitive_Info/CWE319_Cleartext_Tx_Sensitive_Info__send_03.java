/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_03.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 319 Cleartext Transmission of Sensitive Information
* BadSource:  Establish data as a password
* GoodSource: Use a regular string (non-sensitive string)
* Sinks:
*    GoodSink: encrypted channel
*    BadSink : unencrypted channel
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
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

public class CWE319_Cleartext_Tx_Sensitive_Info__send_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;
        if (5==5)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(credentials.getPassword());
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (5==5)
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
    }

    /* goodG2B1() - use goodsource and badsink by changing first 5==5 to 5!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        if (5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";

        }

        if (5==5)
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
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if (5==5)
        {
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (5==5)
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
    }

    /* goodB2G1() - use badsource and goodsink by changing second 5==5 to 5!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;
        if (5==5)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(credentials.getPassword());
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        if (5==5)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication credentials = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(credentials.getPassword());
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (5==5)
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

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
