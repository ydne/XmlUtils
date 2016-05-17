package org.ydne.xml.locate;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.Test;
import org.w3c.dom.Document;
import org.ydne.xml.XmlParser;
import org.ydne.xml.XsltLocator;

/**
 * Unit tests for {@link ClasspathXsltLocator}.
 */
public class ClasspathXsltLocatorTest {
	
	/** Class under test. */
	private XsltLocator subject = new ClasspathXsltLocator("/test/example/xslt");
	
	@Test
	public void locateShiporderXslt() throws Exception {
		// Given: An XML file with a namespace declaration.
		InputStream is = getClass().getResourceAsStream("/test/example/xml/shiporder.xml");
		
		// Assert: It's there.
		assertNotNull(is);
		
		// Assert: It's an XML file.
		Document node = new XmlParser().parse(is);
		assertNotNull(node);
		
		// Assert: Subject can locate XSLT.
		assertNotNull(subject.getXslt(node));
	}
}
