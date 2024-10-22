<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>Tabla de discos con color rojo si antes del 2000 o verde si posterior al año 2000</h2>
  <table border="1">
        <tr bgcolor="#9acd32">
          <th style="text-align:left">Nombre del disco</th>
          <th style="text-align:left">Año</th>
        </tr>
      <xsl:for-each select="catalogo/cds/cd">
      <xsl:if test="año &gt; 2000">
        <tr>
          <td><span style="color:green"><xsl:value-of select="titulo"/></span></td> 
          <td><xsl:value-of select="año"/></td>
        </tr>
      </xsl:if>  
      <xsl:if test="año &lt; 2000">
        <tr>
          <td><span style="color:red"><xsl:value-of select="titulo"/></span></td> 
          <td><xsl:value-of select="año"/></td>
        </tr>
      </xsl:if>
      </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>