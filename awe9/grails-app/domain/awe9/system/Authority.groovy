package awe9.system

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Authority {

    String authority

    String toString() { authority }

    static mapping = {
	cache true
    }

    static constraints = {
	authority blank: false, unique: true
    }
}
