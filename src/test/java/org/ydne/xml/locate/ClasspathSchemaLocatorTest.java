package org.ydne.xml.locate;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.Test;
import org.w3c.dom.Document;
import org.ydne.xml.SchemaLocator;
import org.ydne.xml.XmlParser;

/**
 * Unit tests for {@link ClasspathSchemaLocator}.
 */
public class ClasspathSchemaLocatorTest {
	
	/** Class under test. */
	private SchemaLocator subject = new ClasspathSchemaLocator();
	
	@Test
	public void locateShiporderSchema() throws Exception {
		// Given: An XML file with a name space declaration.
		InputStream is = getClass().getResourceAsStream("/test/example/xml/shiporder.xml");
		
		// Assert: It's there.
		assertNotNull(is);
		
		// Assert: It's an XML file.
		Document node = new XmlParser().parse(is);
		assertNotNull(node);
		
		// Assert: Subject can locate schema.
		assertNotNull(subject.getSchema(node));
	}
}