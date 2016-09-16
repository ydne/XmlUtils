package org.ydne.xml;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;

public interface XsltValidator {
	
	final String XPATH_COUNT_EXPRESSION = "count(%s)";
	
	final XPathFactory xPathfactory = XPathFactory.newInstance();
	final XPath xpath = xPathfactory.newXPath();
	
	default public boolean validateOccurrence(Node xml, String xPath, Integer expected) throws XPathExpressionException {
		XPathExpression countExpression = xpath.compile(String.format(XPATH_COUNT_EXPRESSION, xPath));
		String countAsString = countExpression.evaluate(xml);
		Integer count = Integer.valueOf(countAsString);
		return expected.equals(count);
	}
	
	boolean validate(Node xml, String xPath, Integer expected) throws Exception;
}
