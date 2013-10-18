package awe9.organization

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class Participation {

    static mapWith = "mongo"

    ObjectId id

    Person person
    Party party

    ParticipationRole role

    static constraints = {
        person()
        party()
        role()
    }
}
