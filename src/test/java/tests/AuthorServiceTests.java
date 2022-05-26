package tests;

import authors.Author;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import service.AuthorService;
import service.ServiceAsserter;
import utils.FileManager;

import javax.xml.soap.*;


public class AuthorServiceTests {

    AuthorService authorService = new AuthorService();
    SOAPMessage soapResponse;
    ServiceAsserter serviceAsserter = new ServiceAsserter();
    Author validAuthor = FileManager.getValidAuthor();


    @Test(description = "Create author test case")
    public void createAuthorTestCase() throws SOAPException {
        soapResponse = authorService.createAuthor(validAuthor);
        serviceAsserter.assertCompareAuthors(soapResponse, validAuthor, "ns2:createAuthorResponse");
    }


    @Test(description = "Get author test case")
    public void getAuthorTestCase() throws SOAPException {
        soapResponse = authorService.createAuthor(validAuthor);
        serviceAsserter.assertCompareAuthors(soapResponse, validAuthor, "ns2:createAuthorResponse");
        soapResponse = authorService.getAuthor(validAuthor.getAuthorId());
        serviceAsserter.assertCompareAuthors(soapResponse, validAuthor, "ns2:getAuthorResponse");
    }

    @Test(description = "Delete author test case")
    public void deleteAuthorTestCase() throws SOAPException {
        soapResponse = authorService.createAuthor(validAuthor);
        serviceAsserter.assertCompareAuthors(soapResponse, validAuthor, "ns2:createAuthorResponse");
        soapResponse = authorService.deleteAuthor(validAuthor.getAuthorId());
        serviceAsserter.assertCompareStatus(soapResponse,"Successfully deleted author 25", "ns2:deleteAuthorResponse");
    }
    @AfterMethod
    public void clearData() throws SOAPException {
        authorService.deleteAuthor(validAuthor.getAuthorId());
    }
}
