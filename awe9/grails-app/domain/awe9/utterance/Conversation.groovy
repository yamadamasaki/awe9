package awe9.utterance

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import awe9.type.Type

@ToString
@EqualsAndHashCode
class Conversation {

    static mapWith = "mongo"

    ObjectId id

    Type type

    static hasMany = [utterances:Utterance]

    static constraints = {
        type()
        utterances nullable:true
    }
}
