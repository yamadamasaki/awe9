package awe9.organization

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class PartyRelationship {

    static mapWith = "mongo"

    ObjectId id

    Party source
    Party target

    PartyRelationshipType type

    static constraints = {
        source()
        target()
        type()
    }
}
