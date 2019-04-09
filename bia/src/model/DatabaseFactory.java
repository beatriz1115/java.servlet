package model;

import java.sql.SQLException;
import java.util.Properties;

public class DatabaseFactory {
	private static Properties props;
	private static String base;

	public static Database getDatabase() throws Exception {
		DatabaseFactory.props = DatabaseParams.getProp();
		DatabaseFactory.base = props.getProperty("database");
		if (base.equals("oracle")) {
			try {
				return DatabaseOracle.getDatabase();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (base.equals("postgresql")) {
			try {
				return DatabasePostgresql.getDatabase();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		throw new Exception("Banco de dados desconhecido!");
	}
}
