package awe9.utterance

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import awe9.system.User
import awe9.type.Type

@ToString
@EqualsAndHashCode
class Utterance {

    transient springSecurityService

    static mapWith = "mongo"

    ObjectId id

    String content
    User who = new User()
    Date when = new Date(0)
    // where

    Type type

    static hasMany = [contexts:Context]
    static embedded = ['contexts']

    static transients = ['springSecurityService']

    static constraints = {
        who()
        when()
        content()
        contexts nullable:true
    }

    def beforeInsert() {
        when = new Date()
        who = springSecurityService.currentUser
    }
}
