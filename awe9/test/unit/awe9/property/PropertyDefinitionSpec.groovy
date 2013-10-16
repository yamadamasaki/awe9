package awe9.property

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PropertyDefinition)
class PropertyDefinitionSpec extends Specification {

    def setup() {
        awe9.TestUtils.addAddTos(PropertyDefinition)
    }

    def cleanup() {
    }

    void "属性を定義する"() {
    given:
    when:
    new PropertyDefinition(name:'書誌情報')
    .addToEntries(new PropertyDefinitionEntry(name:'タイトル', type:'String', description:'本の題名を表す'))
    .addToEntries(new PropertyDefinitionEntry(name:'出版日', type:'Date', description:'本が出版された日'))
    .save(flush:true)
    then:
    PropertyDefinition.findByName('書誌情報').entries.size() == 2
    PropertyDefinition.findByName('書誌情報').entries.find { it.name == '出版日'}
    }

    void "属性を定義する (define版)"() {
    given:
    when:
    PropertyDefinition.define(
        '書誌情報',
        [[name:'タイトル', type:'String', description:'本の題名を表す'],
         [name:'出版日', type:'Date', description:'本が出版された日']],
        "本の情報を表すものです"
    )
    then:
    PropertyDefinition.findByName('書誌情報').entries.size() == 2
    PropertyDefinition.findByName('書誌情報').entries.find { it.name == '出版日'}
    }

}
