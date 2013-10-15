package awe9.property

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class PropertyDefinitionEntry {

    static mapWith = "mongo"

    String name
    String type
    //Boolean multiplicity = false
    //Boolean optionality = true
    //String defaultValue

    String description

    static constraints = {
        name()
        type()
    	description nullable:true
    }

    static PropertyDefinitionEntry define(Map m) {
    	(m as PropertyDefinitionEntry)
    }
}
