package awe9.utterance

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

import awe9.property.PropertyDefinition

@ToString
@EqualsAndHashCode
class UtteranceType {

    static mapWith = "mongo"

    ObjectId id

    String name
    String description

    static hasMany = [propertyDefinitions:PropertyDefinition]

    static constraints = {
        name()
        propertyDefinitions nullable:true
        description nullable:true        
    }
}
