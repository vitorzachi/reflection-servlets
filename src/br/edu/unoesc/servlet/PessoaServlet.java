package br.edu.unoesc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unoesc.banco.PessoaBanco;
import br.edu.unoesc.fabricaDeObjetos.FabricaDeObjetos;
import br.edu.unoesc.model.Pessoa;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/PessoaServlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PessoaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cadastroPessoa.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Pessoa pessoa = new FabricaDeObjetos<>(Pessoa.class)
								.criarDo(request);

		PessoaBanco.add(pessoa);

		request.setAttribute("listaPessoas", PessoaBanco.getPessoas());

		request.getRequestDispatcher("listaPessoa.jsp").forward(request, response);
	}

}
