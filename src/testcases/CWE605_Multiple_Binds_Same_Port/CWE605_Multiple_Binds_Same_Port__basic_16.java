/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE605_Multiple_Binds_Same_Port__basic_16.java
Label Definition File: CWE605_Multiple_Binds_Same_Port__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 605 Multiple binds to the same port
* Sinks:
*    GoodSink: two binds on different ports
*    BadSink : two binds on one port
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE605_Multiple_Binds_Same_Port;

import testcasesupport.*;

import java.net.ServerSocket;
import java.net.InetSocketAddress;

import java.io.IOException;

import java.util.logging.Level;

public class CWE605_Multiple_Binds_Same_Port__basic_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            ServerSocket socket1 = null;
            ServerSocket socket2 = null;
            try
            {
                socket1 = new ServerSocket();
                socket1.bind(new InetSocketAddress(15000));
                socket2 = new ServerSocket();
                /* FLAW: This will bind a second Socket to port 15000, but only for connections from localhost */
                socket2.bind(new InetSocketAddress("localhost", 15000));
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Unable to bind a socket", exceptIO);
            }
            finally
            {
                try
                {
                    if (socket2 != null)
                    {
                        socket2.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                }

                try
                {
                    if (socket1 != null)
                    {
                        socket1.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                }
            }
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            ServerSocket socket1 = null;
            ServerSocket socket2 = null;
            try
            {
                socket1 = new ServerSocket();
                socket1.bind(new InetSocketAddress(15000));
                socket2 = new ServerSocket();
                /* FIX: This will bind the second Socket to a different port */
                socket2.bind(new InetSocketAddress("localhost", 15001));
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Unable to bind a socket", exceptIO);
            }
            finally
            {
                try
                {
                    if (socket2 != null)
                    {
                        socket2.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                }

                try
                {
                    if (socket1 != null)
                    {
                        socket1.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                }
            }
            break;
        }
    }

    public void good() throws Throwable
    {
        good1();
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
