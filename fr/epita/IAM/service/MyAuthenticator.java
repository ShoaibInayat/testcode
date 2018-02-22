package fr.epita.IAM.service;

/**
 * this class has the functionality of authentication
 * 
 * @author shoaibinayat
 *
 */
public class MyAuthenticator {

	public static boolean authenticate(String userName, String password) {
		return "root".equals(userName) && "root".equals(password);

	}

}

