package service;

import authors.Author;
import utils.SoapLogger;

import javax.xml.soap.*;

public class AuthorService {

    public SOAPMessage createAuthor(Author authorObject) throws SOAPException {
        SOAPConnection soapConnection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage soapRequest = MessageFactory.newInstance().createMessage();
        SOAPPart soapPart = soapRequest.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        soapEnvelope.addNamespaceDeclaration("lib", "libraryService");
        SOAPBody soapBody = soapEnvelope.getBody();

        SOAPElement createAuthorRequest = soapBody.addChildElement("createAuthorRequest","lib");
          SOAPElement author = createAuthorRequest.addChildElement("author","lib");

            SOAPElement authorId = author.addChildElement("authorId","lib");
            authorId.addTextNode(authorObject.getAuthorId().toString());

            SOAPElement authorName = author.addChildElement("authorName","lib");
              SOAPElement firstName = authorName.addChildElement("first","lib");
              firstName.addTextNode(authorObject.getAuthorName().getFirst());
              SOAPElement secondName = authorName.addChildElement("second","lib");
              secondName.addTextNode(authorObject.getAuthorName().getSecond());

            SOAPElement authorNationality = author.addChildElement("nationality", "lib");
            authorNationality.addTextNode(authorObject.getNationality());

            SOAPElement birth = author.addChildElement("birth","lib");
              SOAPElement date = birth.addChildElement("date", "lib");
              date.addTextNode(authorObject.getBirth().getDate());
              SOAPElement country = birth.addChildElement("country","lib");
              country.addTextNode(authorObject.getBirth().getCountry());
              SOAPElement city = birth.addChildElement("city","lib");
              city.addTextNode(authorObject.getBirth().getCity());


            SOAPElement authorDescription = author.addChildElement("authorDescription","lib");
            authorDescription.addTextNode(authorObject.getAuthorDescription());
            soapRequest.saveChanges();
            SoapLogger.logRequest(soapRequest, "createAuthorRequest");

        SOAPMessage soapResponse = soapConnection.call(soapRequest,"http://localhost:8080/ws");
        SoapLogger.logResponse(soapResponse);

      return soapResponse;
    }

    public SOAPMessage getAuthor(Long authId) throws SOAPException {
        SOAPConnection soapConnection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage soapRequest = MessageFactory.newInstance().createMessage();
        SOAPPart soapPart = soapRequest.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        soapEnvelope.addNamespaceDeclaration("lib","libraryService");
        SOAPBody soapBody = soapEnvelope.getBody();

        SOAPElement getAuthorRequest = soapBody.addChildElement("getAuthorRequest", "lib");
        SOAPElement authorId = getAuthorRequest.addChildElement("authorId", "lib");
        authorId.addTextNode(authId.toString());
        soapRequest.saveChanges();
        SoapLogger.logRequest(soapRequest, "getAuthorRequest");

        //String requestString = ToXml.xmlToString(soapRequest);
        // System.out.println(requestString);
        // SoapLogger.logRequest(soapRequest, "getAuthorRequest");

        SOAPMessage soapResponse = soapConnection.call(soapRequest, "http://localhost:8080/ws");
        SoapLogger.logResponse(soapResponse);
        soapConnection.close();

        return soapResponse;
    }

    public SOAPMessage deleteAuthor(Long authId) throws SOAPException {
        SOAPConnection soapConnection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage soapRequest = MessageFactory.newInstance().createMessage();
        SOAPPart soapPart = soapRequest.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        soapEnvelope.addNamespaceDeclaration("lib","libraryService");
        SOAPBody soapBody = soapEnvelope.getBody();

        SOAPElement deleteAuthorRequest = soapBody.addChildElement("deleteAuthorRequest","lib");
        SOAPElement authorId = deleteAuthorRequest.addChildElement("authorId","lib");
        authorId.addTextNode(authId.toString());

        SOAPElement options = deleteAuthorRequest.addChildElement("options","lib");
        SOAPElement forcibly = options.addChildElement("forcibly","lib");
        forcibly.addTextNode("false");
        SoapLogger.logRequest(soapRequest,"deleteAuthorRequest");

        SOAPMessage soapResponse = soapConnection.call(soapRequest, "http://localhost:8080/ws");

        soapConnection.close();
        return soapResponse;
    }

}
