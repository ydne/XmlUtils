package org.ydne.xml.parse;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.ydne.xml.DomParser;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NamespaceAwareParserTest {
	
	private DomParser subject = new NamespaceAwareParser();
	
	@Test
	public void test() throws Exception {
		// Given: An XML file with a namespace declaration.
		InputStream is = getClass().getResourceAsStream("/test/example/xml/shiporder.xml");
		
		// Assert: It's there.
		assertNotNull(is);
		
		// Assert: It's an XML file.
		Document node = subject.parse(is);
		assertNotNull(node);
		
		// Assert: There is a namespace.
		Node element = node.getFirstChild();
		assertNotNull(element.getNamespaceURI());
		assertNotEquals("", element.getNamespaceURI());
	}

}
