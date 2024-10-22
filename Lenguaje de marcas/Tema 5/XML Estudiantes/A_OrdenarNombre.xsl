<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>Ordenando los nombres alfabeticamente</h2>
  <ol>
      <xsl:for-each select="clase/estudiante">
      <xsl:sort select="nombre" data-type="number" order="descending"/>
        <li><xsl:value-of select="nombre"/></li> 
      </xsl:for-each>
  </ol>
</body>
</html>
</xsl:template>
</xsl:stylesheet>