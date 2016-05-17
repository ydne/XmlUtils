package org.ydne.xml.validate;

import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Node;
import org.ydne.xml.SchemaLocator;
import org.ydne.xml.XmlSchemaValidator;

public class DefaultXmlSchemaValidator implements XmlSchemaValidator {

	private SchemaLocator schemaLocator;

	public DefaultXmlSchemaValidator(SchemaLocator schemaLocator) {
		super();
		this.schemaLocator = schemaLocator;
	}

	/* (non-Javadoc)
	 * @see org.ydne.xml.XmlSchemaValidator#validate(org.w3c.dom.Node)
	 */
	public void validate(Node xml) throws Exception {

		if (xml == null) {
			throw new IllegalArgumentException("Argument 'xml' can not be null!");
		}
		
		// Locate schema.
		URL url = schemaLocator.getSchema(xml);
		StreamSource source = new StreamSource(url.openStream());
		source.setSystemId(url.toString());

		// Load schema.
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(source);
		
		// Validate.
		Validator validator = schema.newValidator();
		validator.validate(new DOMSource(xml));
	}

	public SchemaLocator getSchemaLocator() {
		return schemaLocator;
	}

	public void setSchemaLocator(SchemaLocator schemaLocator) {
		this.schemaLocator = schemaLocator;
	}
}
