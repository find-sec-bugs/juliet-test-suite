/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__screen_capture_02.java
Label Definition File: CWE506_Embedded_Malicious_Code.badonly.label.xml
Template File: point-flaw-badonly-02.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: screen_capture
*    BadSink : Perform a screen capture and save it to a file
*	 BadOnly (No GoodSink)
* Flow Variant: 02 Control flow: if(true)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;

public class CWE506_Embedded_Malicious_Code__screen_capture_02 extends AbstractTestCaseBadOnly
{
    public void bad() throws Throwable
    {
        if (true)
        {
            /* adapted from http://www.java-tips.org/java-se-tips/java.awt/how-to-capture-screenshot.html */
            try
            {
                Robot robot = new Robot();
                /* FLAW: Capture the screen shot of the area of the screen defined by the rectangle */
                BufferedImage screenCapture = robot.createScreenCapture(new Rectangle(100,100));
                ImageIO.write(screenCapture, "jpg", new File("C:/screen.jpg"));
            }
            catch (AWTException exceptAWT)
            {
                IO.logger.log(Level.WARNING, "Could not access screen for capture", exceptAWT);
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Could not access file system", exceptIO);
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
