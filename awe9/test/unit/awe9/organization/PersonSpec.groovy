package awe9.organization

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "典型的なインスタンスを生成する"() {
    when:
    new Person(name:"山田正樹").save(flush:true)
    then:
    Person.count() == 1
    Person.findByName("山田正樹")
    }
}
