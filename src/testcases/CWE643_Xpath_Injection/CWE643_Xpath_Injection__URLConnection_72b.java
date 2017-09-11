/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__URLConnection_72b.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;
import java.util.Vector;

import javax.servlet.http.*;

import javax.xml.xpath.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Xpath_Injection__URLConnection_72b
{
    public void badSink(Vector<String> dataVector ) throws Throwable
    {
        String data = dataVector.remove(2);

        String xmlFile = null;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            xmlFile = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";
        }
        else
        {
            /* running on non-Windows */
            xmlFile = "./src/testcases/CWE643_Xpath Injection/CWE643_Xpath_Injection__Helper.xml";
        }

        if (data != null)
        {
            /* assume username||password as source */
            String [] tokens = data.split("||");
            if (tokens.length < 2)
            {
                return;
            }
            String username = tokens[0];
            String password = tokens[1];
            /* build xpath */
            XPath xPath = XPathFactory.newInstance().newXPath();
            InputSource inputXml = new InputSource(xmlFile);
            /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
             *     The user input should be canonicalized before validation. */
            /* POTENTIAL FLAW: user input is used without validate */
            String query = "//users/user[name/text()='" + username +
                           "' and pass/text()='" + password + "']" +
                           "/secret/text()";
            String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(Vector<String> dataVector ) throws Throwable
    {
        String data = dataVector.remove(2);

        String xmlFile = null;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            xmlFile = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";
        }
        else
        {
            /* running on non-Windows */
            xmlFile = "./src/testcases/CWE643_Xpath Injection/CWE643_Xpath_Injection__Helper.xml";
        }

        if (data != null)
        {
            /* assume username||password as source */
            String [] tokens = data.split("||");
            if (tokens.length < 2)
            {
                return;
            }
            String username = tokens[0];
            String password = tokens[1];
            /* build xpath */
            XPath xPath = XPathFactory.newInstance().newXPath();
            InputSource inputXml = new InputSource(xmlFile);
            /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
             *     The user input should be canonicalized before validation. */
            /* POTENTIAL FLAW: user input is used without validate */
            String query = "//users/user[name/text()='" + username +
                           "' and pass/text()='" + password + "']" +
                           "/secret/text()";
            String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(Vector<String> dataVector ) throws Throwable
    {
        String data = dataVector.remove(2);

        String xmlFile = null;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            xmlFile = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";
        }
        else
        {
            /* running on non-Windows */
            xmlFile = "./src/testcases/CWE643_Xpath Injection/CWE643_Xpath_Injection__Helper.xml";
        }

        if (data != null)
        {
            /* assume username||password as source */
            String [] tokens = data.split("||");
            if( tokens.length < 2 )
            {
                return;
            }
            /* FIX: validate input using StringEscapeUtils */
            String username = StringEscapeUtils.escapeXml(tokens[0]);
            String password = StringEscapeUtils.escapeXml(tokens[1]);
            /* build xpath */
            XPath xPath = XPathFactory.newInstance().newXPath();
            InputSource inputXml = new InputSource(xmlFile);
            String query = "//users/user[name/text()='" + username +
                           "' and pass/text()='" + password + "']" +
                           "/secret/text()";
            String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
        }

    }
}
