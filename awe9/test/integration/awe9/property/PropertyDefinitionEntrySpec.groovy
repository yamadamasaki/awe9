package awe9.property

import spock.lang.*

class PropertyDefinitionEntrySpec extends Specification {

    def setup() {
        awe9.MongoUtils.deleteAllInstances(PropertyDefinitionEntry)
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
