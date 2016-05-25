<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:example="http://test/example/schema/shiporder/1_0">
<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" />
  <xsl:template match="/">
    <example:shiporder>
      <xsl:attribute name="orderid">
        <xsl:value-of select="/example:shiporder/@orderid"/>
      </xsl:attribute>
      <example:orderperson>
        <xsl:value-of select="/example:shiporder/example:orderperson"/>
      </example:orderperson>
      <example:shipto>
        <example:name>
          <xsl:value-of select="/example:shiporder/example:shipto/example:name"/>
        </example:name>
        <example:address>
          <xsl:value-of select="/example:shiporder/example:shipto/example:address"/>
        </example:address>
        <example:country>
          <xsl:value-of select="/example:shiporder/example:shipto/example:country"/>
        </example:country>
      </example:shipto>
      <xsl:for-each select="/example:shiporder/example:item">
        <example:item>
          <example:title>
            <xsl:value-of select="example:title"/>
          </example:title>
          <example:quantity>
            <xsl:value-of select="example:quantity"/>
          </example:quantity>
          <example:price>
            <xsl:value-of select="example:price"/>
          </example:price>
        </example:item>
      </xsl:for-each>
    </example:shiporder>
  </xsl:template>
</xsl:stylesheet>