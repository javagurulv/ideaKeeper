package lv.javaguru.ideakeeper.database;

public class DatabaseMigrationException extends RuntimeException {

	public DatabaseMigrationException(String message, Throwable cause) {
		super(message, cause);
	}
}
