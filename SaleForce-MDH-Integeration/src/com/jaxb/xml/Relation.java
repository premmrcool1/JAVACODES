//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.01 at 04:27:57 PM IST 
//


package com.jaxb.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}type"/>
 *         &lt;element ref="{}rtype"/>
 *         &lt;element ref="{}reltype"/>
 *         &lt;element ref="{}ref"/>
 *         &lt;element ref="{}relref"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "rtype",
    "reltype",
    "ref",
    "relref"
})
@XmlRootElement(name = "relation")
public class Relation {

    @XmlElement(required = true)
    protected String type;
    protected short rtype;
    protected short reltype;
    @XmlElement(required = true)
    protected String ref;
    @XmlElement(required = true)
    protected String relref;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the rtype property.
     * 
     */
    public short getRtype() {
        return rtype;
    }

    /**
     * Sets the value of the rtype property.
     * 
     */
    public void setRtype(short value) {
        this.rtype = value;
    }

    /**
     * Gets the value of the reltype property.
     * 
     */
    public short getReltype() {
        return reltype;
    }

    /**
     * Sets the value of the reltype property.
     * 
     */
    public void setReltype(short value) {
        this.reltype = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

    /**
     * Gets the value of the relref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelref() {
        return relref;
    }

    /**
     * Sets the value of the relref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelref(String value) {
        this.relref = value;
    }

}
