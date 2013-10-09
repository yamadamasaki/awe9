package awe9

class MongoUtils {

	static deleteAllInstances(clazz) {
		if (clazz.count()) clazz.all.each { it.delete(flush:true) }
		assert clazz.count() == 0
	}

}
