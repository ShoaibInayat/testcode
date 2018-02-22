/**
 * IdentityJDBCDAO has all the functionality related to database
 */
package fr.epita.IAM.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.IAM.datamodel.Identity;
import fr.epita.IAM.exceptions.IdentityCreationExceptions;
import fr.epita.IAM.exceptions.IdentityDeleteException;
import fr.epita.IAM.exceptions.IdentitySearchException;
import fr.epita.IAM.exceptions.IdentityUpdateException;

public class IdentityJDBCDAO implements IdentityDAO {
	/**
	 * Declaration for database connection object
	 */
	Connection connection;
	public Connection existingConnection;

	/**
	 * implementation of create function it has almost the same functionality as
	 * the solution provided in class
	 */
	@Override
	public void create(Identity identity) throws IdentityCreationExceptions {

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO IDENTITIES(UID, DISPLAY_NAME, EMAIL) values (?,?,?) ");
			preparedStatement.setString(1, identity.getUid());
			preparedStatement.setString(2, identity.getDisplayName());
			preparedStatement.setString(3, identity.getEmail());
			preparedStatement.execute();

		} catch (ClassNotFoundException | SQLException e) {
			// LOGGER.error("error in create method :" + e.getMessage());
			IdentityCreationExceptions businessException = new IdentityCreationExceptions(identity, e);

			throw businessException;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	/**
	 * implementation of update function
	 */
	@Override
	public void update(Identity identity) throws IdentityUpdateException {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE IDENTITIES SET DISPLAY_NAME = ?, EMAIL = ? WHERE UID = ?");

			preparedStatement.setString(1, identity.getDisplayName());
			preparedStatement.setString(2, identity.getEmail());
			preparedStatement.setString(3, identity.getUid());
			preparedStatement.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * implementation of delete function
	 */
	@Override
	public void delete(Identity identity) throws IdentityDeleteException {
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM IDENTITIES WHERE UID = ?");
			preparedStatement.setString(1, identity.getUid());
			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	/**
	 * implementation of search function it has almost the same functionality as
	 * the solution provided in class
	 */
	@Override
	public List<Identity> search(Identity criteria) throws IdentitySearchException {

		List<Identity> identities = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT UID, DISPLAY_NAME, EMAIL FROM IDENTITIES WHERE DISPLAY_NAME = ? OR EMAIL = ? OR UID = ? ");
			preparedStatement.setString(3, criteria.getUid());
			preparedStatement.setString(1, criteria.getDisplayName());
			preparedStatement.setString(2, criteria.getEmail());

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Identity identity = new Identity();
				identity.setDisplayName(resultSet.getString(2));
				identity.setEmail(resultSet.getString(3));
				identity.setUid(resultSet.getString(1));
				identities.add(identity);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// LOGGER.error("error while searching", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				// LOGGER.error("unresolved error", e);
			}
		}

		return identities;
	}

	/**
	 * 
	 * @return existing connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection getConnection() throws ClassNotFoundException, SQLException {

		try {
			String userName = "root";
			String password = "root";
			String connectionString = "jdbc:derby://localhost:1527/ROOT;create=true";
			existingConnection = DriverManager.getConnection(connectionString, userName, password);
		} catch (Exception e) {
			System.out.println(e);

		}

		return existingConnection;
	}

}

