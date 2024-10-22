<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <title>Tabla de discos con color rojo si antes del 2000 o verde si posterior al año 2000</title>
        <body>
        <h2>Tabla de discos con color rojo si antes del 2000 o verde si posterior al año 2000</h2>
            
            <table border="1">
            <xsl:apply-templates select="catalogo/artistas/cds/cd"/>
            <tr bgcolor="#9acd32">
                <th style="text-align:left">Nombre del disco</th>
                <th style="text-align:left">Año</th>
            </tr>
            </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="cd">
        <tr>
            <td><xsl:value-of select="titulo"/></td> 
            <td><xsl:value-of select="año"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>