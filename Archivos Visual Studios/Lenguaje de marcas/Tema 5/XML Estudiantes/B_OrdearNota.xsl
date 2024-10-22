<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>Ordenando por la calificacion</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">nombre</th>
      <th style="text-align:left">calificacion</th>
    </tr>
      <xsl:for-each select="clase/estudiante">
      <xsl:sort select="calificacion" order="descending"/>
      <tr>
        <td>nombre: <xsl:value-of select="nombre"/></td> 
        <td>calificacion: <xsl:value-of select="calificacion"/></td>
      </tr>
      </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>