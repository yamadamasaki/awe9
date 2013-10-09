package awe9.system

import org.apache.commons.lang.builder.HashCodeBuilder

class UserAuthority implements Serializable {

	private static final long serialVersionUID = 1

	User user
	Authority authority

	boolean equals(other) {
		if (!(other instanceof UserAuthority)) {
			return false
		}

		other.user?.id == user?.id &&
			other.authority?.id == authority?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (authority) builder.append(authority.id)
		builder.toHashCode()
	}

	static UserAuthority get(long userId, long authorityId) {
		UserAuthority.where {
			user == User.load(userId) &&
			authority == Authority.load(authorityId)
		}.get()
	}

	static UserAuthority create(User user, Authority authority, boolean flush = false) {
		new UserAuthority(user: user, authority: authority).save(flush: flush, insert: true)
	}

	static boolean remove(User u, Authority r, boolean flush = false) {

		int rowCount = UserAuthority.where {
			user == User.load(u.id) &&
			authority == Authority.load(r.id)
		}.deleteAll()

		rowCount > 0
	}

	static void removeAll(User u) {
		UserAuthority.where {
			user == User.load(u.id)
		}.deleteAll()
	}

	static void removeAll(Authority r) {
		UserAuthority.where {
			authority == Authority.load(r.id)
		}.deleteAll()
	}

	static mapping = {
		id composite: ['authority', 'user']
		version false
	}
}
