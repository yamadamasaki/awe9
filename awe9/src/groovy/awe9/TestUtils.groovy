package awe9

class TestUtils {

    static addAddTos(Class clazz) {
        def hasMany = clazz.metaClass.properties.find { it.name == "hasMany" }
        hasMany.getProperty(clazz).each { k, v ->
            clazz.metaClass."addTo${k.capitalize()}" = { delegate."${k}"?delegate."${k}".add(it):(delegate."${k}"=[it]); delegate }
        }
    }

}
