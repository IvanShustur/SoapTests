package utils;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public class XmlToString {
    public static String xmlToString(SOAPMessage soapMessage) throws SOAPException {
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = null;
        try {
            tf = tff.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
                "2");

        Source sc = null;
        sc = soapMessage.getSOAPPart().getContent();
        ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(streamOut);
        try {
            tf.transform(sc, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return streamOut.toString();
    }
}
