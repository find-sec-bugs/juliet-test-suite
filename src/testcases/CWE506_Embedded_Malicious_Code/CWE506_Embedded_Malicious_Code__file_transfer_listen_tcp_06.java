/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__file_transfer_listen_tcp_06.java
Label Definition File: CWE506_Embedded_Malicious_Code.badonly.label.xml
Template File: point-flaw-badonly-06.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: file_transfer_listen_tcp
*    BadSink : Send file contents over the network using a listening tcp connection
*     BadOnly (No GoodSink)
* Flow Variant: 06 Control flow: if(PRIVATE_STATIC_FINAL_FIVE==5)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.io.File;
import java.io.FileInputStream;

import java.util.logging.Level;

public class CWE506_Embedded_Malicious_Code__file_transfer_listen_tcp_06 extends AbstractTestCaseBadOnly
{
    /* The variable below is declared "final", so a tool should be able
     * to identify that reads of this will always give its initialized
     * value.
     */
    private static final int PRIVATE_STATIC_FINAL_FIVE = 5;

    public void bad() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE == 5)
        {
            String contents = "";
            File file = new File("C:\\data.txt");
            FileInputStream streamFileInput = null;
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;
            try
            {
                /* read string from file */
                streamFileInput = new FileInputStream(file);
                readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
                contents = readerBuffered.readLine();
                /* This will be reading the first "line" of the file, which
                 * could be very long if there are little or no newlines in the file */
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* clean up stream reading objects */
                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }

                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
            ServerSocket listener = null;
            Socket socket = null;
            OutputStreamWriter writerOutputStream = null;
            BufferedWriter writerBuffered = null;
            try
            {
                /* send file contents using socket */
                listener = new ServerSocket(39543);
                socket = listener.accept();
                writerOutputStream = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
                writerBuffered = new BufferedWriter(writerOutputStream);
                /* FLAW: Send file contents over the network */
                if (contents != null)
                {
                    writerBuffered.write(contents);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream writing", exceptIO);
            }
            finally
            {
                /* clean up stream writing objects */
                try
                {
                    if (writerBuffered != null )
                    {
                        writerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", exceptIO);
                }

                try
                {
                    if (writerOutputStream != null )
                    {
                        writerOutputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", exceptIO);
                }

                /* clean up socket objects */
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

                try
                {
                    if (listener != null)
                    {
                        listener.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing ServerSocket", exceptIO);
                }
            }
        }
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
