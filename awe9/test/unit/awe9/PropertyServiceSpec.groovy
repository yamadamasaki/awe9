package awe9

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PropertyService)
@Mock([awe9.property.PropertyDefinition, awe9.property.PropertyDefinitionEntry])
class PropertyServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "プロパティを定義する"() {
    when:
    service.defineProperty(
        '書誌情報',
        [[name:'タイトル', type:'String', description:'本の題名を表す'],
         [name:'出版日', type:'Date', description:'本が出版された日']],
        "本の情報を表すものです"
    )
    then:
    service.find('書誌情報').entries.size() == 2
    service.find('書誌情報').entries.find { it.name == '出版日'}
    }

    void "複数のプロパティ・セットを定義する"() {
    when:
    service.defineProperty(
        '書誌情報1',
        [[name:'タイトル', type:'String', description:'本の題名を表す'],
         [name:'出版日', type:'Date', description:'本が出版された日']],
        "本の情報を表すものです"
    )
    service.defineProperty(
        '書誌情報2',
        [[name:'題名', type:'String', description:'本の題名を表す'],
         [name:'日付け', type:'Date', description:'本が出版された日'],
         [name:'著者', type:'String', description:'著者']],
        "本の情報を表すものです"
    )
    then:
    service.find('書誌情報2').entries.size() == 3
    service.find('書誌情報2').entries.find { it.name == '日付け'}
    }

    void "プロパティを更新する"() {
    when: "最初にプロパティを定義する"
    service.defineProperty(
        '書誌情報',
        [[name:'タイトル', type:'String', description:'本の題名を表す'],
         [name:'出版日', type:'Date', description:'本が出版された日']],
        "本の情報を表すものです"
    )
    def pd = service.find('書誌情報')
    then: "最初に定義したプロパティが得られる"
    pd.entries.size() == 2
    pd.entries.find { it.name == '出版日'}
    when: "プロパティを再定義する"
    service.updateProperty(
        pd,
        [[name:'題名', type:'String', description:'本の題名を表す'],
         [name:'日付け', type:'Date', description:'本が出版された日'],
         [name:'著者', type:'String', description:'著者']],
        "本の情報を表すものです. 更新済"
    )
    pd = service.find('書誌情報')
    then: "最新のプロパティを得る"
    pd.entries.size() == 3
    pd.entries.find { it.name == '日付け'}
    pd.revision == 2
    when: "前のプロパティを得る"
    pd = service.find('書誌情報', 1)
    then:
    pd.entries.size() == 2
    pd.entries.find { it.name == '出版日'}
    }
}
