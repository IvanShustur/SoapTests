package service;

import authors.Author;
import org.testng.Assert;
import utils.ResponseParser;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class ServiceAsserter {
    public static final String EXPECTED_BUT_FOUND = "Expected [%s], but found [%s]";


    public void assertCompareAuthors(SOAPMessage response, Author exp, String responseNameElement) throws SOAPException {
        Assert.assertFalse(response.getSOAPBody().hasFault());
        Author actual = ResponseParser.parseToAuthor(response, responseNameElement);
        Assert.assertEquals(actual, exp, String.format(EXPECTED_BUT_FOUND, actual, exp));

    }
    public void assertCompareStatus(SOAPMessage response, String expected, String responseNameElement) throws SOAPException {
        Assert.assertFalse(response.getSOAPBody().hasFault());
        String actual = ResponseParser.parseToStatus(response, responseNameElement);
        Assert.assertEquals(actual, expected, String.format(EXPECTED_BUT_FOUND, actual, expected));
    }
}
