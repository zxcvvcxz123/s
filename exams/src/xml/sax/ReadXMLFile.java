package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ReadXMLFile {

    public static void main(String argv[]) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bName = false;
                boolean bSubject = false;
                boolean bMark = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("name")) {
                        bName = true;
                    }

                    if (qName.equalsIgnoreCase("subject")) {
                        bSubject = true;
                    }

                    if (qName.equalsIgnoreCase("mark")) {
                        bMark = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("subject")) {
                        System.out.println("End of subject.\n");
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bName) {
                        if (bSubject) {
                            System.out.println("Subject Name: " + new String(ch, start, length));
                        } else {
                            System.out.println("Student Name: " + new String(ch, start, length));
                        }
                        bName = false;
                    }

                    if (bMark) {
                        System.out.println("Mark : " + new String(ch, start, length));
                        bMark = false;
                    }
                }
            };

            saxParser.parse("file.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}