package awe9.organization

import grails.test.mixin.TestFor
import spock.lang.Specification

import awe9.property.PropertyDefinition

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Participation)
class ParticipationSpec extends Specification {

    def setup() {
        mockDomain(Person)
        mockDomain(Party)
        mockDomain(PropertyDefinition)
        mockDomain(PartyType)
        mockDomain(ParticipationRole)
        awe9.TestUtils.addAddTos(PropertyDefinition)
        awe9.TestUtils.addAddTos(PartyType)
        awe9.TestUtils.addAddTos(ParticipationRole)

        new Person(name:"yamadamasaki").save(flush:true)
        new Party(name:"metabolics", type:PartyTypeSpec.definePartyTypeExample()).save(flush:true)
        ParticipationRoleSpec.defineParticipationRoleExample()
    }

    def cleanup() {
    }

    void "典型的なインスタンスを生成する"() {
    when:
    new Participation(
    person:Person.findByName("yamadamasaki"),
    party:Party.findByName("metabolics"),
    role:ParticipationRole.findByName("テスト用役割")).save(flush:true)
    then:
    Participation.count() == 1
    Participation.first().role.name == "テスト用役割"
    }
}
