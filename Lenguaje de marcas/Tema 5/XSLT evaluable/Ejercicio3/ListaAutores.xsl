<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xhtml" indent="yes"/>

    <xsl:template match="artistas">
        <html>
            <body>
                <h2>Lista de Autores españoles</h2>
                <ol>
                    <xsl:apply-templates/>
                </ol>
            </body>
        </html>
    </xsl:template>


    <xsl:template match="catalogo/artistas/artista[nacionalidad!='España']">
    </xsl:template>
    
    <xsl:template match="catalogo/artistas/artista[nacionalidad='España']">
        <li>
            <span style="color:red">Nombre: </span>
            <xsl:value-of select="nombre"/>
        </li>
    </xsl:template>

    <xsl:template match="cds">
    </xsl:template>
    <xsl:template match="discograficas">
    </xsl:template>
</xsl:stylesheet>