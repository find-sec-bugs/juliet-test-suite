/*
* @description A Servlet fails to catch all exceptions, 
* which may reveal sensitive debugging information.
*
* */

/* note on servlets - when a new Servlet is created, it must be listed in the web.xml
* file in order to run.  The easy way to do this is in Eclipse:
*   - right click on testcases in package explorer
*   - select New->Servlet
*   - Check the box that says use an existing Servlet class or JSP
*   - Click browse and select the new Servlet class you have created
*   - Click OK, Next, then Finish  
*   - You should now be able to test the servlet by clicking Run in eclipse  
*/

package testcases.CWE600_Uncaught_Exception_in_Servlet;

import java.util.logging.Level;
import java.io.IOException;
import java.net.InetAddress;
import javax.servlet.http.*;

import testcasesupport.*;

public class CWE600_Uncaught_Exception_in_Servlet__getParameter_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L; /* needed since Servlets are serializable */

    public void bad(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {        
        String ipAddress = request.getRemoteAddr();
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        
        if (inetAddress == null)
        {
            IO.logger.log(Level.WARNING, "Problem getting IP address");
        }
        else
        {
            IO.writeLine("IP= " + inetAddress.getAddress().toString());
        }
        /* FLAW: The exception is being thrown instead of caught. The stackTrace could 
         * include information useful to an attacker
         * Note: Uncaught exceptions will propagate to the application server.
         */
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            String ipAddress = request.getRemoteAddr();
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            
            if (inetAddress == null)
            {
                IO.logger.log(Level.WARNING, "Problem getting IP address");
            }
            else
            {
                IO.writeLine("IP= " + inetAddress.getAddress().toString());
            }
        }
        /* FIX: IOException is caught */        
        catch (IOException exceptIO) 
        {
            IO.logger.log(Level.WARNING, "Problem getting IP address");
        }
    }
    
    public void good(HttpServletRequest request, HttpServletResponse response) 
    {
        good1(request, response);
    }
}
