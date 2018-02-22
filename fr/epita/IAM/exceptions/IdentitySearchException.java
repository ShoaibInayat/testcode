package fr.epita.IAM.exceptions;

import fr.epita.IAM.datamodel.Identity;

public class IdentitySearchException extends Exception {
	Identity faultyIdentity;

	public IdentitySearchException(Identity identity, Exception originalCause) {
		faultyIdentity = identity;
		initCause(originalCause);
	}

	/**
	 *
	 */

	@Override
	public String getMessage() {
		return "PROBLEM OCCURED WHILE SEARCHING THAT IDENTITY IN THE SYSTEM" + faultyIdentity.toString();
	}

}

