package org.ydne.xml.support;

import java.util.Optional;

import org.w3c.dom.Node;

public final class XmlHelper {
	
	public static final Node getFirstElement(Node xml) {
		if (Node.DOCUMENT_NODE == xml.getNodeType()) {
			xml = xml.getFirstChild();
		}
		if (Optional.ofNullable(xml.getNamespaceURI()).orElse("").trim().equals("")) {
			throw new IllegalArgumentException("Namespace URI cannot be null!");
		}
		return xml;
	}

	private XmlHelper() {
		super();
	}
}
