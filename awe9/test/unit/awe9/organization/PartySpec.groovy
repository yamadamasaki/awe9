package awe9.organization

import grails.test.mixin.TestFor
import spock.lang.Specification
import awe9.property.PropertyDefinition

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Party)
class PartySpec extends Specification {

    def setup() {
        mockDomain(PropertyDefinition)
        mockDomain(PartyType)
        awe9.TestUtils.addAddTos(PropertyDefinition)
        awe9.TestUtils.addAddTos(PartyType)
    }

    def cleanup() {
    }

    void "典型的なインスタンスを生成する"() {
    when:
    new Party(name:"メタボリックス", type:PartyTypeSpec.definePartyTypeExample()).save(flush:true)
    then:
    Party.count() == 1
    Party.findByName("メタボリックス")
    }
}
