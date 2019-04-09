package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * Responsável pela leitura dos parametros da base de dados
 */
public class DatabaseParams {

	public static Properties getProp() {
		/*
		 * Implementar leitura de arquivo de configuração.
		 */
		Properties props = new Properties();
		props.setProperty("database", "oracle");
		props.setProperty("database.oracle.host", "localhost");
		props.setProperty("database.oracle.port", "1521");
		props.setProperty("database.oracle.sid", "XE");
		props.setProperty("database.oracle.user", "empat");
		props.setProperty("database.oracle.password", "teste123");
		return props;
		

	}
}
