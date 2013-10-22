package awe9.type

import grails.test.mixin.TestFor
import spock.lang.Specification
import awe9.property.PropertyDefinition

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Type)
@Mock([awe9.property.PropertyDefinition, awe9.property.PropertyDefinitionEntry])
class TypeSpec extends Specification {

    def setup() {
        awe9.TestUtils.addAddTos(Type)

        PropertyDefinition.define(
            '住所',
            [[name:'都道府県', type:'String'], [name:'電話番号', type:'String']])
        PropertyDefinition.define(
            '業績',
            [[name:'売上', type:'Decimal'], [name:'粗利益', type:'Decimal']])
    }

    def cleanup() {
    }

    void "型を定義する"() {
    when:
    Type.define("Party", "企業", ["住所", "業績"])
    then:
    Type.findByTargetClassNameAndName("Party", "企業").revision == 1
    }

    void "属性定義を変更する"() {
    when:
    Type.define("Party", "企業", ["住所", "業績"])
    then:
    def t = Type.findByTargetClassNameAndName("Party", "企業")
    t.revision == 1
    t.name == "企業"
    when:
    t.update(["住所"], "'業績'を廃止しました")
    t = Type.findByTargetClassNameAndNameAndRevision("Party", "企業", 2)
    then:
    t.propertyDefinitions.size() == 1
    }

    void "属性定義内容を変更する"() {
    when:
    Type.define("Party", "企業", ["住所", "業績"])
    then:
    def t = Type.findByTargetClassNameAndName("Party", "企業")
    t.revision == 1
    t.name == "企業"
    when:
    def pd = PropertyDefinition.findByName("業績")
    pd.update([[name:'売上', type:'Decimal'], [name:'粗利益', type:'Decimal'], [name:'取引額', type:'Decimal']], "rev2")
    t.update(["住所", "業績"], "業績の新しいバージョンを使います")
    t = Type.findByTargetClassNameAndNameAndRevision("Party", "企業", 2)
    then:
    t.propertyDefinitions.size() == 2
    t.propertyDefinitions.find { it.name == '業績' }.revision == 2
    }
}
