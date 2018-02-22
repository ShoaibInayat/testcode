package fr.epita.IAM.launcher;

/**
 * this is the launcher class
 */
import java.util.Scanner;
import fr.epita.IAM.service.MyAuthenticator;
import fr.epita.IAM.service.ProcessFlow;

public class Main {

	public static void main(String[] args) {
		System.out.println("WELCOME TO SHOAIB AND RANA'S IDENTITY MANAGEMENT SYSTEM");
		Scanner scanner = new Scanner(System.in);

		System.out.println("USER NAME :");
		String userName = scanner.nextLine();
		System.out.println("PASSWORD :");
		String password = scanner.nextLine();
		/**
		 * check for authentication ; username and password must be "root"
		 */
		if (!MyAuthenticator.authenticate(userName, password) == true) {

			System.out.println("YOUR USERNAME OR PASSWORD ARE NOT CORRECT.TRY AGAIN!");

		} else {
			System.out.println("AUTHENTICATION SUCCESSFUL");
			String input = "";
			while (!"5".equals(input)) {
				
				System.out.println("1. CREATE IDENTITY");
				System.out.println("2. UPDATE IDENTITY");
				System.out.println("3. DELETE IDENTITY");
				System.out.println("4. SEARCH IDENTITY");
				System.out.println("5. QUIT");
				System.out.println("YOUR SELECTION : ");

				input = scanner.nextLine();
				switch (input) {
				/**
				 * Function Call for Insert
				 */
				case "1":

					ProcessFlow.insertIntoIdentity(scanner);
					break;
				/**
				 * Function Call for Update
				 * 				 */
				case "2":

					ProcessFlow.UpdateIdentity(scanner);
					break;
				/**
				 * Function Call for Delete
				 */
				case "3":

					ProcessFlow.deleteIdentity(scanner);
					break;

				/**
				 * Function Call for Search
				 */
				case "4":

					ProcessFlow.searchIdentity(scanner);
					break;

				case "5":
					System.out.println("SEE YOU NEXT TIME.AU REVOIR");
					break;

				default:

					System.out.println("YOUR SELECTED OPTION IS NOT ACCORDING TO SYSTEM'S SPECIFIED INPUT PARAMETERS");
					System.out.println("ENTER 1,2,3,4 FOR OPERATIONS AND 5 TO QUIT");
					break;

				}
			}

		}

	}
}




