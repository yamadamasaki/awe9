package awe9.type

import awe9.property.PropertyDefinition
import org.bson.types.ObjectId
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class Type {
    static mapWith = "mongo"

    ObjectId id

    String targetClassName
    String name
    Integer revision = 1
    String description

    static hasMany = [propertyDefinitions:PropertyDefinition]

    static constraints = {
        targetClassName()
        name()
        revision()        
        description nullable:true
        propertyDefinitions nullable:true
    }

    static Type define(String targetClassName, String name, List propertyDefinitionNames, String description = "") {
        if (Type.findByName(name)) {
            null // should use 'update'
        } else {
            newAndSave(targetClassName, name, 1, propertyDefinitionNames, description)
        }
    }

    private static Type newAndSave(String targetClassName, String name, Integer revision, List propertyDefinitionNames, String description = "") {
        def t = new Type(name:name, targetClassName:targetClassName, revision:revision, description:description)
        propertyDefinitionNames.each {
            t.addToPropertyDefinitions(PropertyDefinition.findByNameAndRevision(it, PropertyDefinition.getLatestRevision(it)))
        }
        t.save(flush:true)
    }

    private static Type newAndSave(String targetClassName, String name, Integer revision, Map propertyDefinitions, String description = "") {
        def t = new Type(name:name, targetClassName:targetClassName, revision:revision, description:description)
        propertyDefinitions.each { k, v ->
            t.addToPropertyDefinitions(PropertyDefinition.findByNameAndRevision(k, v))
        }
        t.save(flush:true)
    }

    Type update(List propertyDefinitionNames, String description = "") {
        newAndSave(targetClassName, name, getLatestRevision(targetClassName, name)+1, propertyDefinitionNames, description)
    }

    static Integer getLatestRevision(String targetClassName, String name) {
        Type.createCriteria().get {
            eq("targetClassName", targetClassName)
            eq("name", name)
            projections {
                max("revision")
            }
        }
    }

}
