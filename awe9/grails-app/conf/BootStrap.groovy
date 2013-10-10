import awe9.system.Authority
import awe9.system.User
import awe9.system.UserAuthority

class BootStrap {

    def init = { servletContext ->
        // default roles
        def userAuthority = Authority.findByAuthority('ROLE_USER') ?: new Authority(authority:'ROLE_USER').save(failOnError:true, flush:true)
        def adminAuthority = Authority.findByAuthority('ROLE_ADMIN') ?: new Authority(authority:'ROLE_ADMIN').save(failOnError:true, flush:true)
        
        // predefined admin user
        def adminUser = User.findByUsername('admin') ?: new User(username:'admin', password:'admin', enabled:true).save(failOnError:true, flush:true)
        if (!adminUser.authorities.contains(adminAuthority)) {
            UserAuthority.create(adminUser, adminAuthority, true)
        }
	
	assert Authority.findByAuthority('ROLE_USER')
	assert Authority.findByAuthority('ROLE_ADMIN')
	assert User.findByUsername('admin')
	assert User.findByUsername('admin').authorities.contains(Authority.findByAuthority('ROLE_ADMIN'))
    }
    
    def destroy = {
    }
}
