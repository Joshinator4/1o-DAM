<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Listado de CD'sd de EU</h2>
  <ol>
    <li>Número total de libros: <xsl:value-of select="count(/bookstore/book)"/></li>
    <li>Número de libros que tratan sobre cocina: <xsl:value-of select="count(/bookstore/book[@category = 'COOKING'])"/></li>
    <li>Importe total de todos los libros: <xsl:value-of select="sum(/bookstore/book/price)"/></li>
    <li>Libros que en su descripción incluya la palabra "Recetas": <xsl:value-of select="/bookstore/book[contains(title, 'Recetas')]/title"/></li>
    <li>El libro más caro: <xsl:value-of select="/bookstore/book[price = max(//price)]/title"/></li>
  </ol>
</body>
</html>
</xsl:template>
</xsl:stylesheet>