package fr.epita.IAM.service;

import java.util.List;

import fr.epita.IAM.datamodel.Identity;
import fr.epita.IAM.exceptions.IdentityCreationExceptions;
import fr.epita.IAM.exceptions.IdentityDeleteException;
import fr.epita.IAM.exceptions.IdentitySearchException;
import fr.epita.IAM.exceptions.IdentityUpdateException;

public interface IdentityDAO {

	public void create(Identity identity) throws IdentityCreationExceptions;

	public void update(Identity identity) throws IdentityUpdateException;

	public void delete(Identity identity) throws IdentityDeleteException;

	public List<Identity> search(Identity criteria) throws IdentitySearchException;
	/**
	 * interface class create,update,delete and search; methods are giving
	 * declarations here with exception handling.Identity object is passed into
	 * each method prototype
	 */

}
