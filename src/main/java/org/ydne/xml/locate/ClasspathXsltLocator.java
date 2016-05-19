package org.ydne.xml.locate;

import java.net.URL;

import org.w3c.dom.Node;
import org.ydne.xml.XsltLocator;
import org.ydne.xml.support.XmlHelper;

public class ClasspathXsltLocator implements XsltLocator {
	
	private final String basePath;
	
	public ClasspathXsltLocator(String basePath) {
		super();
		this.basePath = basePath.endsWith("/") ? basePath : basePath + "/";
	}

	/* (non-Javadoc)
	 * @see org.ydne.xml.XsltLocator#getXslt(org.w3c.dom.Node)
	 */
	@Override
	public URL getXslt(Node xml) {
		xml = XmlHelper.getFirstElement(xml);
		
		return getClass().getResource(basePath + xml.getLocalName() + ".xsl");
	}

}
