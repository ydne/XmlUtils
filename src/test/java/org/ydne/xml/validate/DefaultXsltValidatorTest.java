package org.ydne.xml.validate;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.ydne.xml.XsltValidator;
import org.ydne.xml.parse.NamespaceAwareParser;
import org.ydne.xml.test.XsltLocatorStub;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultXsltValidatorTest {
	
	private XsltValidator subject = new DefaultXsltValidator(new XsltLocatorStub());
	
	@Test
	public void testValidate() throws Exception {
		// Given: An XML file with a namespace declaration.
		InputStream is = getClass().getResourceAsStream("/test/example/xml/shiporder.xml");
		
		// Assert: It's there.
		assertNotNull(is);
		
		// Assert: It's an XML file.
		Document node = new NamespaceAwareParser().parse(is);
		assertNotNull(node);

		// Assert: Transformation executed, element is removed.
		subject.validate(node, "//*[local-name() = 'note']", 0);
	}

}
