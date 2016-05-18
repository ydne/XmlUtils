package org.ydne.xml;

import java.io.InputStream;

import org.w3c.dom.Document;

public interface DomParser {

	Document parse(InputStream is) throws Exception;

}
