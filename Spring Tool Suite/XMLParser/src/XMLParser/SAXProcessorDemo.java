package XMLParser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXProcessorDemo {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new XMLEvents();
	}

}

class XMLEvents{
	public XMLEvents() throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated constructor stub
		SAXParserFactory spf=SAXParserFactory.newDefaultInstance();
		SAXParser sp= spf.newSAXParser();
		sp.parse("my.xml", new MyHandler());
	}
}


class MyHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Started Parsing...");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
	System.out.println("End of the parsing");
	}
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName + localName);
		for(int i=0;i<attributes.getLength();i++) {
			System.out.println(attributes.getQName(i)+"  :  "+attributes.getValue(i));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
}