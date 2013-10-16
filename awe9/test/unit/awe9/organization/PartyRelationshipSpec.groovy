package awe9.organization

import grails.test.mixin.TestFor
import spock.lang.Specification

import awe9.property.PropertyDefinition

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PartyRelationship)
class PartyRelationshipSpec extends Specification {

    def setup() {
        mockDomain(PropertyDefinition)
        mockDomain(PartyType)
        mockDomain(Party)
        mockDomain(PartyRelationshipType)
        awe9.TestUtils.addAddTos(PropertyDefinition)
        awe9.TestUtils.addAddTos(PartyType)
        awe9.TestUtils.addAddTos(PartyRelationshipType)

        new Party(name:"組織1", type:PartyTypeSpec.definePartyTypeExample()).save(flush:true)
        new Party(name:"組織2", type:PartyTypeSpec.definePartyTypeExample()).save(flush:true)
        PartyRelationshipTypeSpec.definePartyRelationshipTypeExample()
    }

    def cleanup() {
    }

    void "典型的なインスタンスを生成する"() {
    when:
    new PartyRelationship(
    source:Party.findByName("組織1"),
    target:Party.findByName("組織2"),
    type:PartyRelationshipType.findByName("テスト型")).save(flush:true)
    then:
    PartyRelationship.count() == 1
    PartyRelationship.first().source.name == "組織1"
    PartyRelationship.first().target.name == "組織2"
    }
}
