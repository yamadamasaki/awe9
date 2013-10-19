package awe9.utterance

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class Conversation {

    static mapWith = "mongo"

    ObjectId id

    ConversationType type

    static hasMany = [utterances:Utterance]

    static constraints = {
        type()
        utterances nullable:true
    }
}
