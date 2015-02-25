package lv.javaguru.ideakeeper.database;

import javax.sql.DataSource;

public interface DatabaseMigrationService {

    void execute(DataSource dataSource);
    
}
