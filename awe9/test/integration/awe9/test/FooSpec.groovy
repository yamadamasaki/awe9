package awe9.test

import spock.lang.*

/**
 *
 */
class FooSpec extends Specification {

    def setup() {
	awe9.MongoUtils.deleteAllInstances(Foo)
    }

    def cleanup() {
    }

    void "インスタンスを作る"() {
    given:
    when:
    def foo = new Foo(s:"aaa", d:new Date(), i:100, f:1.0).save(flush:true)
    then:
    Foo.count == 1
    Foo.findByS("aaa")
    Foo.findByS('aaa').f == 1.0
    }
}
