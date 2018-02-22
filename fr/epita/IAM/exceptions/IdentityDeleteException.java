
package fr.epita.IAM.exceptions;

import fr.epita.IAM.datamodel.Identity;

public class IdentityDeleteException extends Exception {
	Identity faultyIdentity;

	public IdentityDeleteException(Identity identity, Exception originalCause) {
		faultyIdentity = identity;
		initCause(originalCause);
	}

	/**
	 *
	 */

	@Override
	public String getMessage() {
		return "PROBLEM OCCURED WHILE DELETING THAT IDENTITY IN THE SYSTEM" + faultyIdentity.toString();
	}

}
