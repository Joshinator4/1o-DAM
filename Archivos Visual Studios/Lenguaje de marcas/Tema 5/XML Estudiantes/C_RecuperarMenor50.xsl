<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>Listado de alumnos que deben recuperar por tener calificacion menor que 50</h2>
  <ul>
      <xsl:for-each select="clase/estudiante">
      <xsl:if test="calificacion &lt; 50">
        <li>nombre: <xsl:value-of select="nombre"/></li> 
        <li>calificacion: <xsl:value-of select="calificacion"/></li> 
      </xsl:if>
      </xsl:for-each>
  </ul>
</body>
</html>
</xsl:template>
</xsl:stylesheet>