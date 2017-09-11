/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_03.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of preferred java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__String_getBytes_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (5 == 5)
        {
            String sentence = "Convert this to bytes";
            byte[] sentenceAsBytes = new byte[sentence.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            sentence.getBytes(0, sentence.length(), sentenceAsBytes, 0);
            IO.writeLine(IO.toHex(sentenceAsBytes)); /* Use sentenceAsBytes */
        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if (5 != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            String sentence = "Convert this to bytes";

            /* FIX: Use preferred String.getBytes() method */
            byte[] sentenceAsBytes = sentence.getBytes("UTF-8");

            IO.writeLine(IO.toHex(sentenceAsBytes)); /* Use sentenceAsBytes */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (5 == 5)
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
        good2();
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
