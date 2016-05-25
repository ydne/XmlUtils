package org.ydne.xml.test;

import java.net.URL;

import org.w3c.dom.Node;
import org.ydne.xml.XmlSchemaLocator;

public class XmlSchemaLocatorStub implements XmlSchemaLocator {

	/* (non-Javadoc)
	 * @see org.ydne.xml.XmlSchemaLocator#getSchema(org.w3c.dom.Node)
	 */
	@Override
	public URL getSchema(Node xml) {
		return getClass().getResource("/test/example/schema/shiporder/1_0/shiporder.xsd");
	}

}
