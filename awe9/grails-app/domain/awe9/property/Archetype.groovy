package awe9.property

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class Archetype {

    static mapWith = "mongo"

    static hasMany = [propertyDefinitions:PropertyDefinition]

    ObjectId id

    String name

    String description

    static constraints = {
        name()
        propertyDefinitions()
    	description nullable:true
    }
}
