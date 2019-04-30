package org.ydne.xml.locate;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.ydne.xml.XsltLocator;
import org.ydne.xml.parse.NamespaceAwareParser;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		Document node = new NamespaceAwareParser().parse(is);
		assertNotNull(node);
		
		// Assert: Subject can locate XSLT.
		assertNotNull(subject.getXslt(node));
	}
}
