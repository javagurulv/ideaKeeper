package lv.javaguru.ideakeeper.database;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;


class DatabaseMigrationServiceImpl implements DatabaseMigrationService {

    private static final Logger log = LoggerFactory.getLogger(DatabaseMigrationServiceImpl.class);
	private static final String MAIN_CHANGE_LOG_FILE = "liquibase/db.changelog-master.xml";

    private boolean enabled;
    private String context;

    DatabaseMigrationServiceImpl(boolean enabled,
                                 String context) {
        this.enabled = enabled;
        this.context = context;
    }

    @Override
    public void execute(DataSource dataSource) {
        if (enabled) {
            Stopwatch watch = Stopwatch.createStarted();
            updateSchema(dataSource);
            log.info("Database populated in " + watch.stop().toString());
        }
    }

    protected void updateSchema(DataSource dataSource) {
		Connection connection = null;
		try {
			connection = tryUpdate(dataSource);
		} catch (Exception e) {
			throw new DatabaseMigrationException("Error while updating the ua.etaxi.core.database", e);
		} finally {
			tryClose(connection);
		}
	}

	protected Connection tryUpdate(DataSource dataSource) throws Exception {
		Connection connection = dataSource.getConnection();

		DatabaseFactory databaseFactory = DatabaseFactory.getInstance();
		Database database = databaseFactory.findCorrectDatabaseImplementation(new JdbcConnection(connection));

		String fileName = MAIN_CHANGE_LOG_FILE;
		Liquibase liquibase = new Liquibase(fileName, new ClassLoaderResourceAccessor(), database);

		liquibase.update(context);
		return connection;
	}

	protected void tryClose(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DatabaseMigrationException("Error while updating the ua.etaxi.core.database", e);
			}
		}
	}

}
