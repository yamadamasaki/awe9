package awe9.utterance

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import awe9.system.User

@ToString
@EqualsAndHashCode
class Utterance {

    static mapWith = "mongo"

    ObjectId id

    String content
    User who
    Date when

    UtteranceType type

    static hasMany = [contexts:Context]
    static embedded = ['contexts']

    static constraints = {
        who()
        when()
        content()
        contexts nullable:true
    }
}
