<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" method="xml" omit-xml-declaration="yes"/>
<xsl:template match="/">

	<xsl:variable name="items" select ="//investments/item"/>
	<portfolio>
		<xsl:for-each select="$items">
			<xsl:variable name="type" select="@type"/>
			<xsl:element name="{@type}">
				<xsl:attribute name="exchange"><xsl:value-of select="@exch"/></xsl:attribute>
				<xsl:element name="name"><xsl:value-of select="@company"/></xsl:element>
				<xsl:element name="{name(@symbol)}"><xsl:value-of select="@symbol"/></xsl:element>
				<xsl:element name="{name(@price)}"><xsl:value-of select="@price"/></xsl:element>
			</xsl:element>
		</xsl:for-each>
	</portfolio>

</xsl:template>
</xsl:stylesheet>