package awe9.organization

import grails.test.mixin.TestFor
import spock.lang.Specification

import awe9.property.PropertyDefinition
import awe9.property.PropertyDefinitionSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ParticipationRole)
class ParticipationRoleSpec extends Specification {

    def setup() {
        mockDomain(PropertyDefinition)
        awe9.TestUtils.addAddTos(PropertyDefinition)
        awe9.TestUtils.addAddTos(ParticipationRole)
    }

    def cleanup() {
    }

    static defineParticipationRoleExample() {
        PropertyDefinitionSpec.definePropertyDefinitionExample()
        new ParticipationRole(name:"テスト用役割", description:"テスト用")
        .addToPropertyDefinitions(PropertyDefinition.findByName("属性定義1"))
        .addToPropertyDefinitions(PropertyDefinition.findByName("属性定義2"))
        .save(flush:true)
    }

    void "典型的なインスタンスを生成する"() {
    when:
    defineParticipationRoleExample()
    then:
    ParticipationRole.count() == 1
    ParticipationRole.findByName("テスト用役割")
    ParticipationRole.findByName("テスト用役割").propertyDefinitions?.size() == 2
    }
}
