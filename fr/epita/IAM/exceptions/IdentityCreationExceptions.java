package fr.epita.IAM.exceptions;

import fr.epita.IAM.datamodel.Identity;

public class IdentityCreationExceptions extends Exception {
	Identity faultyIdentity;

	public IdentityCreationExceptions(Identity identity, Exception originalCause) {
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

