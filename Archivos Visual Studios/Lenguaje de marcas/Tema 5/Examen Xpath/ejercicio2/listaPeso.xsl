<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>Lista ordenada por peso</h2>
  <ul>
      <xsl:for-each select="inventario/producto">
      <xsl:sort select="peso" data-type="number" order="descending"/>
        <li>nombre: <xsl:value-of select="nombre"/> peso: <xsl:value-of select="peso"/></li>
      </xsl:for-each>
  </ul>
</body>
</html>
</xsl:template>
</xsl:stylesheet>