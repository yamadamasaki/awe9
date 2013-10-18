package awe9

import spock.lang.Specification
import awe9.property.PropertyDefinition
import awe9.property.PropertyDefinitionEntry

class TestUtilsSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "指定されたドメインクラスにaddToメソッド群を追加する"() {
    when:
    TestUtils.addAddTos(PropertyDefinition)
    def pd = new PropertyDefinition(name:"aaa")
    then:
    pd.addToEntries(new PropertyDefinitionEntry(name:"bbb", type:"String"))
    pd.entries[0].name == "bbb"
    }

}
