package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabasePostgresql implements Database {
	
	private static DatabasePostgresql instance;
	
	private static Connection conn;
	private static boolean conexaoInvalida = true;
	private Properties props = DatabaseParams.getProp();

	
	private String host = props.getProperty("database.postgresql.host");
	private String port = props.getProperty("database.postgresql.port");
	private String dbName = props.getProperty("database.postgresql.dbName");

	private String user = props.getProperty("database.postgresql.user");
	private String password = props.getProperty("database.postgresql.password");

	public DatabasePostgresql() {

		String url = "jdbc:postgresql://"+host+":"+port+"/"+dbName;
		try {
			// Abrir conexão com DB
			DatabasePostgresql.conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			conexaoInvalida = true;
			e.printStackTrace();
		}

	}
	
	public synchronized static DatabasePostgresql getDatabase() throws SQLException {
		if (instance == null || conexaoInvalida == true) {
			instance = new DatabasePostgresql();
		}else if(conn.isClosed()) {
			instance = new DatabasePostgresql();
		}
		return instance;

	}

	@Override
	public Connection getConection() {
		return DatabasePostgresql.conn;
	}

	@Override
	public void desconectar(Connection conn) {
		try {
			// encerra conexão
			DatabasePostgresql.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
