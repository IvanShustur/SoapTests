package utils;

import authors.Author;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ResponseParser {
    private ResponseParser() {
    }

    public static JSONObject parseToBody(SOAPMessage soapResponse) throws SOAPException {

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try {
            soapResponse.writeTo(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject json = XML.toJSONObject(b.toString());
        json = json.getJSONObject("SOAP-ENV:Envelope")
                .getJSONObject("SOAP-ENV:Body");
        return json;
    }

    private static String deleteNameSpace(JSONObject jsonObject) {
        return jsonObject.toString().replace("ns2:","");
    }

    public static Author parseToAuthor(SOAPMessage soapResponse, String responseName) throws SOAPException {
        JSONObject json = parseToBody(soapResponse)
                .getJSONObject(responseName)
                .getJSONObject("ns2:author");
        String jsonString = deleteNameSpace(json);
        ObjectMapper mapper = new ObjectMapper();
        Author author = null;
        try {
            author = mapper.readValue(jsonString, Author.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return author;
    }

    public static String parseToStatus (SOAPMessage soapResponse, String responseNameElement) throws SOAPException {
        return ResponseParser.parseToBody(soapResponse)
                .getJSONObject(responseNameElement)
                .getString("ns2:status");
    }
}