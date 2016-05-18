package org.ydne.xml.parse;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.ydne.xml.DomParser;

/**
 * A convenient namespace-aware DOM parser.
 */
public class NamespaceAwareParser implements DomParser {
	
	// Create a new DocumentBuilderFactory.
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	private DocumentBuilder documentBuilder = null;

	public NamespaceAwareParser() {
		super();
		// Configure the DocumentBuilder to be namespace-aware.
		factory.setNamespaceAware(true);
		
		// Create a new DocumentBuilder.
		try {
			documentBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println(String.format("%s - Ignoring exception %s", getClass().getSimpleName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.ydne.xml.DomParser#parse(java.io.InputStream)
	 */
	public Document parse(InputStream is) throws Exception {
		// Parse inputstream.
		return documentBuilder.parse(is);
	}
}
