package awe9.organization

import grails.test.mixin.TestFor
import spock.lang.Specification

import awe9.property.PropertyDefinition
import awe9.property.PropertyDefinitionEntry
import awe9.property.PropertyDefinitionSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PartyType)
class PartyTypeSpec extends Specification {

    def setup() {
        mockDomain(PropertyDefinition)
        awe9.TestUtils.addAddTos(PropertyDefinition)
        awe9.TestUtils.addAddTos(PartyType)
    }

    def cleanup() {
    }

    static definePartyTypeExample() {
        PropertyDefinitionSpec.definePropertyDefinitionExample()
        new PartyType(name:"テスト型", description:"いろいろ")
        .addToPropertyDefinitions(PropertyDefinition.findByName("属性定義1"))
        .addToPropertyDefinitions(PropertyDefinition.findByName("属性定義2"))
        .save(flush:true)
    }

    void "典型的なインスタンスを生成する"() {
    when:
    definePartyTypeExample()
    then:
    PartyType.count() == 1
    PartyType.findByName("テスト型")
    PartyType.findByName("テスト型").propertyDefinitions?.size() == 2
    }
}
