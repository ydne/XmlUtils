package org.ydne.xml;

import org.w3c.dom.Node;

public interface XsltValidator {
	
	boolean validate(Node xml, String xPath, Integer expected) throws Exception;
}
