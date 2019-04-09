package model;

import java.sql.*;
import java.util.Properties;

public class DatabaseOracle implements Database {

	private static DatabaseOracle instance;

	private static Connection conn;
	private static boolean conexaoInvalida;
	private Properties props = DatabaseParams.getProp();

	private String host = props.getProperty("database.oracle.host");
	private String port = props.getProperty("database.oracle.port");
	private String sid = props.getProperty("database.oracle.sid");

	private String user = props.getProperty("database.oracle.user");
	private String password = props.getProperty("database.oracle.password");

	public DatabaseOracle() {

		String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;

		try {
			// Abrir conexão com DB
			DatabaseOracle.conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			conexaoInvalida = true;
			e.printStackTrace();
		}

	}

	public synchronized static DatabaseOracle getDatabase() throws SQLException {
		if (instance == null || conexaoInvalida == true) {
			conexaoInvalida = false;
			instance = new DatabaseOracle();
		}else if(conn.isClosed()) {
			instance = new DatabaseOracle();
		}
		return instance;

	}

	@Override
	public Connection getConection() {
		return DatabaseOracle.conn;
	}

	@Override
	public void desconectar(Connection conn) {
		try {
			// encerra conexão
			DatabaseOracle.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
