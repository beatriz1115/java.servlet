package contato;

public class Contato {
	String nome;
	int idade;
	String email;
	String endereco;
	String cidade;
	String uf;
	String cep;
	

	// Construtor
	public Contato(String nome, int idade, String email, String endereco, String cidade, String uf,
			String cep) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getResumo() {
		return this.nome + ' ' + this.idade + ' ' + this.email;
	}
}