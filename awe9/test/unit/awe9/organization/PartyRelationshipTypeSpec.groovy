package awe9.organization

import grails.test.mixin.TestFor
import spock.lang.Specification

import awe9.property.PropertyDefinition
import awe9.property.PropertyDefinitionEntry
import awe9.property.PropertyDefinitionSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PartyRelationshipType)
class PartyRelationshipTypeSpec extends Specification {

    def setup() {
        mockDomain(PropertyDefinition)
        awe9.TestUtils.addAddTos(PropertyDefinition)
        awe9.TestUtils.addAddTos(PartyRelationshipType)
    }

    def cleanup() {
    }

    static definePartyRelationshipTypeExample() {
        PropertyDefinitionSpec.definePropertyDefinitionExample()
        new PartyRelationshipType(name:"テスト型", description:"いろいろ")
        .addToPropertyDefinitions(PropertyDefinition.findByName("属性定義1"))
        .addToPropertyDefinitions(PropertyDefinition.findByName("属性定義2"))
        .save(flush:true)
    }

    void "典型的なインスタンスを生成する"() {
    when:
    definePartyRelationshipTypeExample()
    then:
    PartyRelationshipType.count() == 1
    PartyRelationshipType.findByName("テスト型")
    PartyRelationshipType.findByName("テスト型").propertyDefinitions?.size() == 2
    }
}
