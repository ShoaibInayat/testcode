package fr.epita.IAM.exceptions;

import fr.epita.IAM.datamodel.Identity;

public class IdentityUpdateException extends Exception {

	Identity faultyIdentity;

	public IdentityUpdateException(Identity identity, Exception originalCause) {
		faultyIdentity = identity;
		initCause(originalCause);
	}

	/**
	 *
	 */

	@Override
	public String getMessage() {
		return "PROBLEM OCCURED WHILE UPDATING THAT IDENTITY IN THE SYSTEM" + faultyIdentity.toString();
	}

}

