package org.ydne.xml.validate;

import java.io.File;
import java.net.URL;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.ydne.xml.XsltLocator;
import org.ydne.xml.XsltValidator;

public class DefaultXsltValidator implements XsltValidator {
	
	private static final String XPATH_COUNT_EXPRESSION = "count(%s)";
	
	private TransformerFactory factory = TransformerFactory.newInstance();
	private XPathFactory xPathfactory = XPathFactory.newInstance();
	private XPath xpath = xPathfactory.newXPath();
	
	private XsltLocator xsltLocator;
	
	public DefaultXsltValidator(XsltLocator xsltLocator) {
		super();
		this.xsltLocator = xsltLocator;
	}

	
	/* (non-Javadoc)
	 * @see org.ydne.xml.XsltValidator#validate(org.w3c.dom.Node, java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean validate(Node xml, String xPath, Integer expected) throws Exception {
		if (xml == null) {
			throw new IllegalArgumentException("Argument 'xml' can not be null!");
		}
		if (xPath == null) {
			throw new IllegalArgumentException("Argument 'xPath' can not be null!");
		}
		if (expected == null) {
			throw new IllegalArgumentException("Argument 'expected' can not be null!");
		}
		
		URL xslt = xsltLocator.getXslt(xml);
		if (xslt == null) {
			return true;
		}
		Source stylesource = new StreamSource(new File(xslt.getFile()));
		
		Transformer transformer = factory.newTransformer(stylesource);
		
		Source before = new DOMSource(xml);
		DOMResult after = new DOMResult();
		transformer.transform(before, after);
		
		XPathExpression countExpression = xpath.compile(String.format(XPATH_COUNT_EXPRESSION, xPath));
		String countAsString = countExpression.evaluate(after.getNode());
		Integer count = Integer.valueOf(countAsString);
		return expected.equals(count);
	}

	public XsltLocator getXsltLocator() {
		return xsltLocator;
	}

	public void setXsltLocator(XsltLocator xsltLocator) {
		this.xsltLocator = xsltLocator;
	}
}
