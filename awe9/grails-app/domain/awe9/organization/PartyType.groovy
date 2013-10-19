package awe9.organization

import org.bson.types.ObjectId
import awe9.property.PropertyDefinition
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class PartyType {

    static mapWith = "mongo"

    ObjectId id

    String name
    String description

    static hasMany = [propertyDefinitions:PropertyDefinition]

    static constraints = {
        name()
        description nullable:true
        propertyDefinitions nullable:true
    }
}
