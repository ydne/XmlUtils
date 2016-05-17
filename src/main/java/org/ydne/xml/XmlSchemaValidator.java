package org.ydne.xml;

import org.w3c.dom.Node;

public interface XmlSchemaValidator {

	void validate(Node xml) throws Exception;
}
