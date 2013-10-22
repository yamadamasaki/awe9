package awe9.utterance

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class Context {

    static mapWith = "mongo"

    ObjectId id

    String uri
    String caption

    static constraints = {
        uri url:true
        caption nullable:true
    }
}
