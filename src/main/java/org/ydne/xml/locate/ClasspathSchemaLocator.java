package org.ydne.xml.locate;

import java.net.URL;

import org.w3c.dom.Node;
import org.ydne.xml.SchemaLocator;
import org.ydne.xml.support.XmlHelper;

public class ClasspathSchemaLocator implements SchemaLocator {

	public URL getSchema(Node xml) {
		xml = XmlHelper.getFirstElement(xml);
		
		String elementName = xml.getLocalName();
		String name = parseNamespaceToResourceName(xml);
		
		return getClass().getResource(name + elementName + ".xsd");
	}

	private String parseNamespaceToResourceName(Node xml) {
		String namespace = xml.getNamespaceURI().startsWith("http") ? xml.getNamespaceURI().substring(4, xml.getNamespaceURI().length()) : xml.getNamespaceURI();
		namespace = namespace.startsWith("s://") ? namespace.substring(3, namespace.length()) : namespace;
		namespace = namespace.startsWith("://") ? namespace.substring(2, namespace.length()) : namespace;
		namespace = namespace.endsWith("/") ? namespace : namespace + "/";
		return namespace;
	}
}
