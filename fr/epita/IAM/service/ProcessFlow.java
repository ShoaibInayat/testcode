package fr.epita.IAM.service;

/**
 * this class has the functionalities of create,update,search and delete identity
 */
import java.util.Scanner;

import fr.epita.IAM.service.IdentityJDBCDAO;
import fr.epita.IAM.exceptions.IdentityDeleteException;
import fr.epita.IAM.exceptions.IdentitySearchException;
import fr.epita.IAM.datamodel.Identity;
import fr.epita.IAM.exceptions.IdentityCreationExceptions;
import fr.epita.IAM.exceptions.IdentityUpdateException;

public class ProcessFlow {
	/**
	 * Insert into Identity is the function for insertion which takes the input
	 * from user; create instance of identityJDBCDAO and calls the create
	 * function
	 * 
	 * @param scanner
	 */
	public static void insertIntoIdentity(Scanner scanner) {
		System.out.println("INSERT DESIRED IDENTITY");
		System.out.println("PLEASE ENTER YOUR DISPLAY NAME:");
		String displayName = scanner.nextLine();
		System.out.println("PLEASE ENTER YOUR EMAIL ID:");
		String email = scanner.nextLine();
		System.out.println("PLEASE ENTER YOUR USER ID:");
		String uid = scanner.nextLine();
		Identity identity = new Identity(displayName, email, uid);

		try {
			IdentityJDBCDAO createDAO = new IdentityJDBCDAO();
			createDAO.create(identity);
			System.out.println("YOUR DATA IS INSERTED SUCCESSFULLY");
		} catch (IdentityCreationExceptions e) {
			System.out.println("UNFORTUNATELY, IDENTITY COULD NOT BE INSERTED");
			e.printStackTrace();
		}

	}

	/**
	 * DeleteIdentity is the function for deletion which takes the input from
	 * user; create instance of identityJDBCDAO andcalls the delete function
	 * 
	 * @param scanner
	 */

	public static void deleteIdentity(Scanner scanner) {
		System.out.println("DELETE DESIRED IDENTITY");
		System.out.println("PLEASE ENTER THE IDENTITY UID TO DELETE:");
		String idToBeDeleted = scanner.nextLine();
		Identity identity1 = new Identity(null, null, idToBeDeleted);

		try {
			IdentityJDBCDAO delDAO = new IdentityJDBCDAO();
			delDAO.delete(identity1);
			System.out.println("YOUR SELECTED IDENTITY HAS BEEN DELETED");
		} catch (IdentityDeleteException e) {
			System.out.println("SOME PROBLEM OCCURED IN DELETION OF IDENTITY, CONTACT ADMIN!");
			e.printStackTrace();
		}
	}

	/**
	 * UpdateIdentity is the function for updation which takes the input from
	 * user; create instance of identityJDBCDAO and calls the update function
	 * 
	 * @param scanner
	 */
	public static void UpdateIdentity(Scanner scanner) {

		System.out.println("UPDATE DESIRED IDENTITY");
		System.out.println("ENTER UID OF IDENTITY WHICH YOU WANT TO MODIFY:");
		String idToBeUpdate = scanner.nextLine();
		System.out.println("ENTER DISPLAYNAME WHICH YOU WANT TO MODIFY:");
		String nameToBeUpdate = scanner.nextLine();
		System.out.println("ENTER EMAIL WHICH YOU WANT TO MODIFY:");
		String emailToBeUpdate = scanner.nextLine();
		Identity identity2 = new Identity(idToBeUpdate, nameToBeUpdate, emailToBeUpdate);
		try {

			IdentityJDBCDAO updateDAO = new IdentityJDBCDAO();
			updateDAO.update(identity2);
			System.out.println("YOUR DESIRED IDENTITY HAS BEEN UPDATED");
		} catch (IdentityUpdateException e) {
			System.out.println("A PROBLEM OCCURED IN YOUR DESIRED IDENTITY UPDATION.CONTACT ADMIN!");
			e.printStackTrace();
		}
	}

	/**
	 * SearchIdentity is the function for search which takes the input from
	 * user; create instance of identityJDBCDAO and calls the search function
	 * 
	 * @param scanner
	 */
	public static void searchIdentity(Scanner scanner) {
		System.out.println("SEARCH FOR YOUR DESIRED IDENTITY");
		System.out.println("PLEASE ENTER UID OF IDENTITY TO BE SEARCHED:");
		String idToBeSearched = scanner.nextLine();
		Identity identity3 = new Identity(null, null, idToBeSearched);

		try {
			IdentityJDBCDAO searchDAO = new IdentityJDBCDAO();
			System.out.println("Desired Identity" + "=" + searchDAO.search(identity3));

		} catch (IdentitySearchException e) {
			System.out.println("SOME ERROR OCCURED.CONTACT ADMIN!");
			e.printStackTrace();
		}

	}

}

