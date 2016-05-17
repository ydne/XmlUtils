package org.ydne.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XmlParser {
	
	// create a new DocumentBuilderFactory
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	private DocumentBuilder documentBuilder = null;

	public XmlParser() throws Exception {
		super();
		// configure the DocumentBuilder to be namespace aware
		factory.setNamespaceAware(true);
		
		// create a new DocumentBuilder
		documentBuilder = factory.newDocumentBuilder();
	}
	
	public Document parse(InputStream is) throws Exception {
		// parse inputstream.
		return documentBuilder.parse(is);
	}
}
