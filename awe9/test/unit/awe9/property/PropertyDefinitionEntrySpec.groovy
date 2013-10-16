package awe9.property

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PropertyDefinitionEntry)
class PropertyDefinitionEntrySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "一つの属性を定義する"() {
    given:
    when:
    new PropertyDefinitionEntry(name:'タイトル', type:'String', description:'本の題名を表す').save(flush:true)
    new PropertyDefinitionEntry(name:'出版日', type:'Date', description:'本が出版された日').save(flush:true)
    then:
    PropertyDefinitionEntry.findByName('タイトル').type == 'String'
    }

}
