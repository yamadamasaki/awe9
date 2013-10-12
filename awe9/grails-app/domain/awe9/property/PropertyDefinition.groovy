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

    static hasMany = [entries:PropertyDefinitionEntry]
    static embedded = ['entries']

    static constraints = {
    }

    static PropertyDefinition define(String name, List entries) {
    	def pd = new PropertyDefinition(name:name)
    	entries.each {
	    pd.addToEntries(PropertyDefinitionEntry.define(it))
    	}
    	pd.save(flush:true)
    }

}
