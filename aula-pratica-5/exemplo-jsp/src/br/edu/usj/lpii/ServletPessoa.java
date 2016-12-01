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
@WebServlet("/cadastroPessoa")
public class ServletPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ListaPessoas lista = new ListaPessoas();
		lista.popula();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListaPessoas listaPessoas = new ListaPessoas();
		List<Pessoa> pessoas = listaPessoas.getListaPessoas();		
						
		request.setAttribute("pessoas", pessoas);
		RequestDispatcher rd = request.getRequestDispatcher("/listar-pessoas.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListaPessoas listaPessoas = new ListaPessoas();
		List<Pessoa> pessoas = listaPessoas.getListaPessoas();		
		
		if ("cadastrar".equals(request.getParameter("acao"))) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			listaPessoas.adiciona(nome, email);
			/*
			Pessoa p = new Pessoa();
			p.setNome(nome);
			p.setEmail(email);
			pessoas.add(p);
			*/
		}
		else if ("remover".equals(request.getParameter("acao"))) {
			String email = request.getParameter("email");
			listaPessoas.remove(email);		
		}

		pessoas = listaPessoas.getListaPessoas();
		request.setAttribute("pessoas", pessoas);
		RequestDispatcher rd = request.getRequestDispatcher("/listar-pessoas.jsp");
		rd.forward(request, response);
	}
}
