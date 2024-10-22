<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Listado de CD'sd de EU</h2>
  <ol>
    <xsl:for-each select="/catalog/cd[country='EU']">
    <li>Titulo: <xsl:value-of select="title"/>  // Compañía: <xsl:value-of select="company"/> // Precio: <xsl:value-of select="price"/></li>
    </xsl:for-each>
  </ol>
</body>
</html>
</xsl:template>
</xsl:stylesheet>