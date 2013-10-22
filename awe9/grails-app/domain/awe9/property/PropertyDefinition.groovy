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
    Integer revision = 1
    Set entries

    String description

    static hasMany = [entries:PropertyDefinitionEntry]
    static embedded = ['entries']

    static constraints = {
        name()
        revision()
        entries()
    	description nullable:true
    }

    static PropertyDefinition define(String name, List entries, String description = "") {
        if (PropertyDefinition.findByName(name)) {
            null // should use 'update'
        } else {
            newAndSave(name, 1, entries, description)
        }
    }

    static private PropertyDefinition newAndSave(String name, Integer revision, List entries, String description) {
        def pd = new PropertyDefinition(name:name, revision:revision, description:description)
        entries.each {
            pd.addToEntries(PropertyDefinitionEntry.define(it))
        }
        pd.save(flush:true)
    }

    PropertyDefinition update(List entries, String description = "") {
        newAndSave(name, getLatestRevision(name)+1, entries, description)
    }

    static Integer getLatestRevision(String name) {
        PropertyDefinition.createCriteria().get {
            eq("name", name)
            projections {
                max("revision")
            }
        }
    }

}
