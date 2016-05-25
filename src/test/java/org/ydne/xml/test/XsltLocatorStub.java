package org.ydne.xml.test;

import java.net.URL;

import org.w3c.dom.Node;
import org.ydne.xml.XsltLocator;

public class XsltLocatorStub implements XsltLocator {

	/* (non-Javadoc)
	 * @see org.ydne.xml.XsltLocator#getXslt(org.w3c.dom.Node)
	 */
	@Override
	public URL getXslt(Node xml) {
		return getClass().getResource("/test/example/xslt/shiporder.xsl");
	}

}
