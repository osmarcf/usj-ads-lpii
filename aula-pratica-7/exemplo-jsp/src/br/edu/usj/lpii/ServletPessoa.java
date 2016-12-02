package br.edu.usj.lpii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPessoa
 */
@WebServlet("/pessoa")
public class ServletPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PessoasDAO pessoasDAO = new PessoasDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPessoa() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
	
		if ("editar".equals(acao)) {
			editaPessoa(request, response);
		}
		else if ("remover".equals(acao)) {
			removePessoa(request, response);
			listaPessoa(request, response);
		}
		else {
			listaPessoa(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if ("cadastrar".equals(acao)) {
			cadastraPessoa(request, response);
			listaPessoa(request, response);
		}
		else if ("atualizar".equals(request.getParameter("acao"))) {
			atualizaPessoa(request, response);
			listaPessoa(request, response);
		}
		else if ("pesquisar".equals(request.getParameter("acao"))) {
			pesquisaPessoa(request, response);
		}
	}
	
	private void cadastraPessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setNome(nome);
		novaPessoa.setEmail(email);

		pessoasDAO.adiciona(novaPessoa);
	}
	
	private void pesquisaPessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setEmail(email);

		List<Pessoa> pessoas = pessoasDAO.pesquisa(pessoa);		
		
		request.setAttribute("pessoas", pessoas);
		RequestDispatcher rd = request.getRequestDispatcher("/pesquisa-pessoas.jsp");
		rd.forward(request, response);	
	}

	private void listaPessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pessoa> pessoas = pessoasDAO.getLista();		
						
		request.setAttribute("pessoas", pessoas);
		RequestDispatcher rd = request.getRequestDispatcher("/lista-pessoas.jsp");
		rd.forward(request, response);
	}
	
	private void editaPessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("idPessoa"));

		Pessoa pessoa = pessoasDAO.getPessoa(id);
		
		request.setAttribute("pessoa", pessoa);		
		RequestDispatcher rd = request.getRequestDispatcher("/cadastro-pessoa.jsp");
		rd.forward(request, response);
	}
	
	private void atualizaPessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("idPessoa"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setId(id);
		novaPessoa.setNome(nome);
		novaPessoa.setEmail(email);

		int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
		
		pessoasDAO.atualiza(idPessoa, novaPessoa);		
	}

	private void removePessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("idPessoa"));

		pessoasDAO.remove(id);
	}
}
