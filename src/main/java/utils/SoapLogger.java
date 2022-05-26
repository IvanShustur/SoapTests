package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class SoapLogger {
    private static final Logger logger = LogManager.getLogger(SoapLogger.class);

    private SoapLogger() {
    }

    public static void logRequest(SOAPMessage request, String requestName) throws SOAPException {
        String requestString = XmlToString.xmlToString(request);
        String log = "\nREQUEST Name:  " + requestName +"\n" + requestString;
        logger.info(log);

    }

    public static void logResponse(SOAPMessage response) throws SOAPException {
        String responseString = XmlToString.xmlToString(response);
        String log = "\nRESPONSE:\n" + responseString;
        logger.info(log);
    }
}
