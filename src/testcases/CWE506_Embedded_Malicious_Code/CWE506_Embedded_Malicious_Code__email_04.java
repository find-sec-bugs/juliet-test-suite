/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__email_04.java
Label Definition File: CWE506_Embedded_Malicious_Code.badonly.label.xml
Template File: point-flaw-badonly-04.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: email
*    BadSink : Send an e-mail
*     BadOnly (No GoodSink)
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CWE506_Embedded_Malicious_Code__email_04 extends AbstractTestCaseBadOnly
{
    /* The variable below are is "final", so a tool should
     * be able to identify that reads of it will always return its
     * initialized value.
     */
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;

    public void bad() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            Properties properties = new Properties();
            Session session = Session.getDefaultInstance(properties, null);
            String messageBody = "...";
            try
            {
                Message message = new MimeMessage(session); /* INCIDENTAL: CWE506 Encoded Payload */
                message.setFrom(new InternetAddress("sender@example.com"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("recipient@example.com"));
                message.setSubject("Shhh, I'm sending some bad stuff!");
                message.setText(messageBody);
                /* FLAW: Send an e-mail */
                Transport.send(message);
            }
            catch (AddressException exceptAddress)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block
                 */
                IO.logger.log(Level.WARNING, "Address is formatted incorrectly", exceptAddress);
            }
            catch (MessagingException exceptMessaging)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block
                 */
                IO.logger.log(Level.WARNING, "Error sending message", exceptMessaging);
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
