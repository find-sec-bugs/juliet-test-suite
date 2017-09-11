/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE510_Trapdoor__network_listen_08.java
Label Definition File: CWE510_Trapdoor.badonly.label.xml
Template File: point-flaw-badonly-08.tmpl.java
*/
/*
* @description
* CWE: 510 Trapdoor
* Sinks: network_listen
*    BadSink : Presence of a network listener
*     BadOnly (No GoodSink)
* Flow Variant: 08 Control flow: if(privateReturnsTrue())
*
* */

package testcases.CWE510_Trapdoor;

import testcasesupport.*;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;

public class CWE510_Trapdoor__network_listen_08 extends AbstractTestCaseBadOnly
{
    /* The method below always return the same value, so a tool
     * should be able to figure out that every call to this
     * methods will return true.
     */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    public void bad() throws Throwable
    {
        if (privateReturnsTrue())
        {
            ServerSocket listener = null;
            Socket socket = null;
            int port = 30000;
            try
            {
                listener = new ServerSocket(port); /* INCIDENTAL: Use of Socket */
                /* wait for first connection */
                /* FLAW: Listening for network connection */
                socket = listener.accept();
                /* connection successful, so do stuff */
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Could not listen on port " + Integer.toString(port), exceptIO);
            }
            finally
            {
                try
                {
                    if (socket != null)
                    {
                        socket.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", exceptIO);
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
                    IO.logger.log(Level.WARNING, "Error closing objects", exceptIO);
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
