/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__URLConnection_22b.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.xml.xpath.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Xpath_Injection__URLConnection_22b
{
    public void badSink(String data ) throws Throwable
    {
        if (CWE643_Xpath_Injection__URLConnection_22a.badPublicStatic)
        {
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1Sink(String data ) throws Throwable
    {
        if (CWE643_Xpath_Injection__URLConnection_22a.goodB2G1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

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

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2Sink(String data ) throws Throwable
    {
        if (CWE643_Xpath_Injection__URLConnection_22a.goodB2G2PublicStatic)
        {
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        if (CWE643_Xpath_Injection__URLConnection_22a.goodG2BPublicStatic)
        {
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
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
    }
}
