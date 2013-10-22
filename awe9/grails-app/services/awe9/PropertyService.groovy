package awe9

import awe9.property.PropertyDefinition
import awe9.property.PropertyDefinitionEntry

class PropertyService {

    static transactional = 'mongo'

    def defineProperty(name, entries, description = "") {
        PropertyDefinition.define(name, entries, description)
    }

    def updateProperty(definition, entries, description = "") {
        definition.update(entries, description)
    }

    def find(name, revision = 0) {
        PropertyDefinition.findByNameAndRevision(name, revision?:PropertyDefinition.getLatestRevision(name))
    }

}
