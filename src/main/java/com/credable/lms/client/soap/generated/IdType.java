
package com.credable.lms.client.soap.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for idType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="idType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="PASSPORT"/>
 *     <enumeration value="NATIONAL_ID"/>
 *     <enumeration value="DRIVERS_LICENSE"/>
 *     <enumeration value="VOTERS_ID"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "idType")
@XmlEnum
public enum IdType {

    PASSPORT,
    NATIONAL_ID,
    DRIVERS_LICENSE,
    VOTERS_ID;

    public String value() {
        return name();
    }

    public static IdType fromValue(String v) {
        return valueOf(v);
    }

}
