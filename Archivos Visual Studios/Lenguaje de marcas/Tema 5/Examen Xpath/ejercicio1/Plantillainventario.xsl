<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>EdificioA</h2>
  <table border="1">
        <tr bgcolor="#9acd32">
          <th style="text-align:left"> Producto</th>
          <th style="text-align:left">Peso</th>
          <th style="text-align:left">Localizacion</th>
        </tr>
      <xsl:for-each select="inventario/producto">
        <xsl:if test="lugar[@edificio = 'A']">
        <tr>
          <td><xsl:value-of select="nombre"/></td> 
          <td><xsl:value-of select="peso"/></td>
          <td><xsl:value-of select="lugar"/><xsl:value-of select="lugar/@edificio"/></td>
        </tr>
        </xsl:if>
      </xsl:for-each>
  </table>

  <h2>EdificioB</h2>
  <table border="1">
        <tr bgcolor="#9acd32">
          <th style="text-align:left"> Producto</th>
          <th style="text-align:left">Peso</th>
          <th style="text-align:left">Localizacion</th>
        </tr>
        <xsl:for-each select="inventario/producto">
        <xsl:if test="lugar[@edificio = 'B']">
        <tr>
          <td><xsl:value-of select="nombre"/></td> 
          <td><xsl:value-of select="peso"/></td>
          <td><xsl:value-of select="lugar"/><xsl:value-of select="lugar/@edificio"/></td>
        </tr>
      </xsl:if>  
      </xsl:for-each>
  </table>

</body>
</html>
</xsl:template>
</xsl:stylesheet>