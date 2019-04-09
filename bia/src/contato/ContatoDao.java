package contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.DatabaseFactory;
import model.DatabaseParams;

public class ContatoDao {
	
	private Properties props = DatabaseParams.getProp();
	private String base = props.getProperty("database");
	private Connection conn;
	
	public ContatoDao() throws Exception {
		this.conn = DatabaseFactory.getDatabase().getConection();
		System.out.println(this.base);
	}
	public void adiciona(Contato contato) {
		String sql = "INSERT INTO CONTATO(NOME, IDADE, TELEFONE) VALUES(?,?,?)";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setInt(2, contato.idade);
			stmt.setString(3, contato.email);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
