package XMLParser;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomProcessor {

	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setIgnoringElementContentWhitespace(true);

		DocumentBuilder db=dbf.newDocumentBuilder();
		
		
		Document doc=db.parse("my.xml");
		
		Element rootElement= doc.getDocumentElement();
		
		System.out.println(rootElement.getNodeName());
		
		System.out.println(rootElement.getChildNodes().getLength());
		
		System.out.println(rootElement.getFirstChild().getNodeName());//book
		System.out.println(rootElement.getFirstChild().getFirstChild().getNodeType());//name
		System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild().getNodeType());//name
		System.out.println("--------------------------------------------------------------------------");
		doPrintEverything(rootElement);
		System.out.println(doc.getDoctype());
		
	}
	
	public static void doPrintEverything(Node node) {
		if(node.hasChildNodes()) {
			System.out.println(node.getNodeName());
			for(int i=0;i<node.getChildNodes().getLength();i++) {
				doPrintEverything(node.getChildNodes().item(i));
			}
		}else {
			System.out.println(node.getNodeName()+"  :  "+node.getNodeValue());
			return;
		}
	}
}
















