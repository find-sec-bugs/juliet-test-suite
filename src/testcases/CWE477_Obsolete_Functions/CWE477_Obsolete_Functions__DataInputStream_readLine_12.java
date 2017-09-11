/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__DataInputStream_readLine_12.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: DataInputStream_readLine
*    GoodSink: Use of preferred BufferedReader.readLine() method
*    BadSink : Use deprecated DataInputStream.readLine() method
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataInputStream;

public class CWE477_Obsolete_Functions__DataInputStream_readLine_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* Read a line of user input from console with deprecated DataInputStream.readLine() method */
            {
                /* FLAW: Read input from the console using DataInputStream.readLine() */
                DataInputStream streamDataInput = new DataInputStream(System.in);
                String myString = streamDataInput.readLine();
                IO.writeLine(myString); /* Use myString */
                /* NOTE: Tools may report a flaw here because streamDataInput is not closed.  Unfortunately, closing that will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }
        }
        else
        {

            /* Read a line of user input from console with preferred BufferedReader.readLine() method */
            {
                InputStreamReader readerInputStream = new InputStreamReader(System.in, "UTF-8");
                BufferedReader readerBuffered = new BufferedReader(readerInputStream);

                /* FIX: Read input from the console using preferred method BufferedReader.readLine() */
                String myString = readerBuffered.readLine();

                IO.writeLine(myString); /* Use myString */

                /* NOTE: Tools may report a flaw here because readerBuffered and readerInputStream are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* Read a line of user input from console with preferred BufferedReader.readLine() method */
            {
                InputStreamReader readerInputStream = new InputStreamReader(System.in, "UTF-8");
                BufferedReader readerBuffered = new BufferedReader(readerInputStream);
                /* FIX: Read input from the console using preferred method BufferedReader.readLine() */
                String myString = readerBuffered.readLine();
                IO.writeLine(myString); /* Use myString */
                /* NOTE: Tools may report a flaw here because readerBuffered and readerInputStream are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }
        }
        else
        {

            /* Read a line of user input from console with preferred BufferedReader.readLine() method */
            {
                InputStreamReader readerInputStream = new InputStreamReader(System.in, "UTF-8");
                BufferedReader readerBuffered = new BufferedReader(readerInputStream);

                /* FIX: Read input from the console using preferred method BufferedReader.readLine() */
                String myString = readerBuffered.readLine();

                IO.writeLine(myString); /* Use myString */

                /* NOTE: Tools may report a flaw here because readerBuffered and readerInputStream are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }

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
