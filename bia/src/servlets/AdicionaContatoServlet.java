package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contato.Contato;
import contato.ContatoDao;


@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		int idade = Integer.parseInt(request.getParameter("idade"));
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("estado");
		String cep = request.getParameter("cep");
		
		String nomeCompleto = nome +" "+ sobrenome;

		Contato contato = new Contato(nomeCompleto, idade, email, endereco, cidade, uf, cep);
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + contato.getResumo() +
                " adicionado com sucesso");
        out.println("</body>");
        out.println("</html>");
    }
}