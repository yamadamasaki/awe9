package awe9.organization

import org.bson.types.ObjectId
import awe9.property.PropertyDefinition
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class ParticipationRole {

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
