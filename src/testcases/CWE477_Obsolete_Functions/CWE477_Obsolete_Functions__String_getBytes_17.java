/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_17.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of preferred java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__String_getBytes_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        for(int j = 0; j < 1; j++)
        {
            String sentence = "Convert this to bytes";
            byte[] sentenceAsBytes = new byte[sentence.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            sentence.getBytes(0, sentence.length(), sentenceAsBytes, 0);
            IO.writeLine(IO.toHex(sentenceAsBytes)); /* Use sentenceAsBytes */
        }
    }

    /* good1() use the GoodSinkBody in the for statement */
    private void good1() throws Throwable
    {
        for(int k = 0; k < 1; k++)
        {
            String sentence = "Convert this to bytes";
            /* FIX: Use preferred String.getBytes() method */
            byte[] sentenceAsBytes = sentence.getBytes("UTF-8");
            IO.writeLine(IO.toHex(sentenceAsBytes)); /* Use sentenceAsBytes */
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
