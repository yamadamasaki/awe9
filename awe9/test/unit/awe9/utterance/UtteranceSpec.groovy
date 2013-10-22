package awe9.utterance

import grails.test.mixin.TestFor
import spock.lang.Specification

import awe9.system.User
import awe9.type.Type

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Utterance)
@Mock([User, Type])
class UtteranceSpec extends Specification {

    def user = new User(username:'yamadamasaki', password:"aaa", accountExpired:false, accountLocked:false, passwordExpired:false)

    def setup() {
        user.springSecurityService = [encodePassword:{ it }] as Object
        user.save(flush:true)
        awe9.TestUtils.addAddTos(Utterance)
    }

    def cleanup() {
    }

    void "典型的なインスタンスを生成する"() {
    when:
    def u = new Utterance(content:"つぶやき...")
    .addToContexts(new Context(uri:"http://www.metabolics.co.jp/", caption:"見てみて!"))
    .addToContexts(new Context(uri:"aaa.jpg"))
    u.type = new Type(targetClassName:"awe9.utterance.Utterance", name:"foo").save(flush:true)
    u.springSecurityService = [currentUser:user] as Object
    u.save(flush:true)
    u = Utterance.first()
    then:
    u.content == "つぶやき..."
    u.contexts.size() == 2
    new Date() - u.when < 1000
    }
}
