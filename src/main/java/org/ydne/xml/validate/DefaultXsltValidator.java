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

public class DefaultXsltValidator {
	
	private TransformerFactory factory = TransformerFactory.newInstance();
	private XPathFactory xPathfactory = XPathFactory.newInstance();
	private XPath xpath = xPathfactory.newXPath();
	
	private XsltLocator xsltLocator;
	
	public DefaultXsltValidator(XsltLocator xsltLocator) {
		super();
		this.xsltLocator = xsltLocator;
	}

	public boolean valideer(Node xml) throws Exception {
		return valideer(xml, null);
	}
	
	public boolean valideer(Node xml, String codeExists) throws Exception {
		
		URL xslt = xsltLocator.getXslt(xml);
		if (xslt == null) {
			return true;
		}
		Source stylesource = new StreamSource(new File(xslt.getFile()));

		Transformer transformer = factory.newTransformer(stylesource);
		
		Source voor = new DOMSource(xml);
		DOMResult na = new DOMResult();
		transformer.transform(voor, na);
		
		if (codeExists == null) {
			XPathExpression telFoutenExpression = xpath.compile("count(//*[local-name() = 'fout'])");
			String aantalFoutenAsString = telFoutenExpression.evaluate(na.getNode());
			Integer aantalFouten = Integer.valueOf(aantalFoutenAsString);
			return aantalFouten==0;
		} else {
			XPathExpression telFoutenExpression = xpath.compile("count(//*[local-name()='Code' and text() = '"+codeExists+"'])");
			String aantalFoutenAsString = telFoutenExpression.evaluate(na.getNode());
			Integer aantalFouten = Integer.valueOf(aantalFoutenAsString);
			return aantalFouten>0;
		}
	}

	public XsltLocator getXsltLocator() {
		return xsltLocator;
	}

	public void setXsltLocator(XsltLocator xsltLocator) {
		this.xsltLocator = xsltLocator;
	}
}
