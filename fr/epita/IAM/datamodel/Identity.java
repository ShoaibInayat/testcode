package fr.epita.IAM.datamodel;

/**
 * 
 * @author shoaibinayat
 *
 */
public class Identity {
	private String displayName;
	private String email;
	private String uid;

	/**
	 * @param displayName
	 * @param email
	 * @param uid
	 */

	public Identity() {

	}

	public Identity(String displayName, String email, String uid) {
		this.displayName = displayName;
		this.email = email;
		this.uid = uid;
		/**
		 * Constructor
		 */
	}

	/**
	 * getter for returning displayName
	 * 
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * setter for setting displayName
	 * 
	 * @param displayName
	 */

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * getter for returning email
	 * 
	 * @return
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * setter for setting email
	 * 
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter for returning uid
	 * 
	 * @return
	 */

	public String getUid() {
		return uid;
	}

	/**
	 * setter for setting uid
	 * 
	 * @param uid
	 */

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Identity [displayName=" + displayName + ", email=" + email + ", uid=" + uid + "]";
	}

	/*
	 * (non-Javadoc) own hash function to handle data
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (displayName == null ? 0 : displayName.hashCode());
		result = prime * result + (email == null ? 0 : email.hashCode());
		result = prime * result + (uid == null ? 0 : uid.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc) checking identity objects parameters
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Identity other = (Identity) obj;
		if (displayName == null) {
			if (other.displayName != null) {
				return false;
			}
		} else if (!displayName.equals(other.displayName)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (uid == null) {
			if (other.uid != null) {
				return false;
			}
		} else if (!uid.equals(other.uid)) {
			return false;
		}
		return true;
	}

}

