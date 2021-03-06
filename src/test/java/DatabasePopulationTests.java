import java.sql.Connection;
import java.sql.SQLException;

import CsvToDatabase.ConnectionUtilities.DatabaseConnection;
import CsvToDatabase.ServiceClasses.PopulateDatabase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * These tests must be run in the order contained or errors will be thrown.
 */
class DatabasePopulationTests
{

	private static Connection databaseConnection;

	@BeforeAll
	static void setupJdbc()
	{
		databaseConnection = DatabaseConnection.getConnection();
	}

	@Test
	void testAbilityToPopulateDataToOrganizationTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updateOrganization();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM organization");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}

	@Test
	void testAbilityToPopulateDataToProgramTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updateProgram();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM program");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}

	@Test
	void testAbilityToPopulateDataToLocationTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updateLocation();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM location");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}

	@Test
	void testAbilityToPopulateDataToServicesTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updateServices();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM service");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}
	@Test
	void testAbilityToPopulateDataToServiceAtLocationTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updateServiceAtLocation();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM service_at_location");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}

	@Test
	void testAbilityToPopulateDataToPhysicalAddressTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updatePhysicalAddress();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM physical_address");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}

	@Test
	void testAbilityToPopulateDataToPhoneTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updatePhone();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM phone");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}

	@Test
	void testAbilityToPopulateRegularScheduleTable()
			throws SQLException
	{
		long numberOfLinesCopied = PopulateDatabase.updateRegularSchedule();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT COUNT(id) FROM regular_schedule");
		resultSet.next();
		resultSet.getInt(1);
		assertTrue(numberOfLinesCopied > 0, "More than one line should be copied");
		assertEquals(numberOfLinesCopied, resultSet.getInt(1),"Copied data should be present in the database");
	}
	

	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}
}
