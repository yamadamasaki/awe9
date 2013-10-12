package awe9.property

import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class PropertyDefinition {

    static mapWith = "mongo"

    ObjectId id

    String name
    Set entries

    String description

    static hasMany = [entries:PropertyDefinitionEntry]
    static embedded = ['entries']

    static constraints = {
        name()
        entries()
    	description nullable:true
    }

    static PropertyDefinition define(String name, List entries) {
        define(name, entries, "")
    }

    static PropertyDefinition define(String name, List entries, String description) {
    	def pd = new PropertyDefinition(name:name, description:description)
    	entries.each {
	    pd.addToEntries(PropertyDefinitionEntry.define(it))
    	}
    	pd.save(flush:true)
    }

}
