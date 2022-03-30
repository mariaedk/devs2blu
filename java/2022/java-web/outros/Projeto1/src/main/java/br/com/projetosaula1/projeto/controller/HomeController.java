package br.com.projetosaula1.projeto.controller;

import java.io.IOException;
// projeto para mostrar como que roda

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// mapear para a raíz do projeto
// configurando o servlet, que vai ser o controller, vai receber a requisição e exibir o conteúdo
@WebServlet(name = "HomeController", urlPatterns = "/")

public class HomeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
