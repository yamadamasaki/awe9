package awe9.organization

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class Party {

    static mapWith = "mongo"

    ObjectId id

    String name

    PartyType type

    static constraints = {
        name()
        type()
    }
}
