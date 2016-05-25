package org.ydne.xml;

import java.net.URL;

import org.w3c.dom.Node;

public interface XmlSchemaLocator {

	URL getSchema(Node xml);

}
