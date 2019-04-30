package org.ydne.xml.locate;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.ydne.xml.XmlSchemaLocator;
import org.ydne.xml.parse.NamespaceAwareParser;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for {@link ClasspathSchemaLocator}.
 */
public class ClasspathSchemaLocatorTest {
	
	/** Class under test. */
	private XmlSchemaLocator subject = new ClasspathSchemaLocator();
	
	@Test
	public void locateShiporderSchema() throws Exception {
		// Given: An XML file with a name space declaration.
		InputStream is = getClass().getResourceAsStream("/test/example/xml/shiporder.xml");
		
		// Assert: It's there.
		assertNotNull(is);
		
		// Assert: It's an XML file.
		Document node = new NamespaceAwareParser().parse(is);
		assertNotNull(node);
		
		// Assert: Subject can locate schema.
		assertNotNull(subject.getSchema(node));
	}
}
