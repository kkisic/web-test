package db.migration;

import java.sql.Connection;
import java.sql.Statement;

public class V20180223__DatabaseInitialization implements org.flywaydb.core.api.migration.jdbc.JdbcMigration {
    public void migrate(Connection connection) throws Exception {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE POST ( ID IDENTITY PRIMARY KEY, AUTHOR VARCHAR(32), TIME TIMESTAMP, BODY0 VARCHAR(5), BODY1 VARCHAR(7), BODY2 VARCHAR(5) )");
    }
}
