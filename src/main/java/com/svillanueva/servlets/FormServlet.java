package com.svillanueva.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String pais = req.getParameter("pais");
		String[] lenguajes = req.getParameterValues("lenguajes");
		String[] roles = req.getParameterValues("roles");


		PrintWriter printWriter = resp.getWriter();

		printWriter.println("<!doctype html>");
		printWriter.println("<html lang=\"en\">");
		printWriter.println("	<head>");
		printWriter.println("		<meta charset=\"UTF-8\">");
		printWriter.println("		<meta name=\"viewport\"\n" +
				"\t\tcontent=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
		printWriter.println("		<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		printWriter.println("		<title>Index Servlet</title>");
		printWriter.println("	</head>");
		printWriter.println("	<body>");

		printWriter.println("		<h1>Resultado Form: </h1>");

		printWriter.println("		<ul>");
		printWriter.println("			<li>Username: " + username + "</li>");
		printWriter.println("			<li>Password: " + password + "</li>");
		printWriter.println("			<li>Email: " + email + "</li>");
		printWriter.println("			<li>Pais: " + pais + "</li>");
		printWriter.println("			<li><ul>");
		for (String lenguaje : lenguajes) {
			printWriter.println("				<li>" + lenguaje + "</li>");
		}
		printWriter.println("			</ul></li>");
		printWriter.println("			<li><ul>");
		for (String rol : roles) {
			printWriter.println("				<li>" + rol + "</li>");
		}
		printWriter.println("			</ul></li>");

		printWriter.println("		</ul>");

		printWriter.println("	</body>");
		printWriter.println("</html>");
		printWriter.close();
	}
}
