package org.ydne.xml;

import org.w3c.dom.Node;

public interface XsltValidator {
	
	public boolean validate(Node xml) throws Exception;
	
	public boolean validate(Node xml, String codeExists);
}
