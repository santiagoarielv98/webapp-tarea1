package com.svillanueva.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		String idioma = req.getParameter("idioma");
		boolean habilitar = req.getParameter("habilitar") != null && req.getParameter("habilitar")
				.equals("on");
		String secreto = req.getParameter("secreto");

		List<String> errores = new ArrayList<>();

		if (username == null || username.isBlank()) {
			errores.add("el username se requerido!");
		}
		if (password == null || password.isBlank()) {
			errores.add("el password no puede ser vació!");
		}
		if (email == null || !email.contains("@")) {
			errores.add("el email es requerido y debe tener un formato de correo.");
		}
		if (pais == null || pais.isBlank()) {
			errores.add("el pais es requerido!");
		}
		if (lenguajes == null || lenguajes.length == 0) {
			errores.add("debe seleccionar al menos un tema.");
		}
		if (roles == null || roles.length == 0) {
			errores.add("debe seleccionar al menos un rol.");
		}
		if (idioma == null) {
			errores.add("debe seleccionar un idioma");
		}

		if (errores.isEmpty()) {
			try (PrintWriter out = resp.getWriter()) {
				out.println("<!doctype html>");
				out.println("<html lang=\"en\">");
				out.println("	<head>");
				out.println("		<meta charset=\"UTF-8\">");
				out.println("		<meta name=\"viewport\"\n" +
						"\t\tcontent=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
				out.println("		<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
				out.println("		<title>Index Servlet</title>");
				out.println("	</head>");
				out.println("	<body>");

				out.println("		<h1>Resultado Form: </h1>");

				out.println("		<ul>");

				out.println("			<li>Username: " + username + "</li>");
				out.println("			<li>Password: " + password + "</li>");
				out.println("			<li>Email: " + email + "</li>");
				out.println("			<li>Pais: " + pais + "</li>");
				out.println("			<li><ul>");
				for (String lenguaje : lenguajes) {
					out.println("				<li>" + lenguaje + "</li>");
				}
				out.println("			</ul></li>");
				out.println("			<li><ul>");
				for (String rol : roles) {
					out.println("				<li>" + rol + "</li>");
				}
				out.println("			</ul></li>");
				out.println("		<li>Idioma:" + idioma + "</li>");
				out.println("		<li>Habilitado: " + habilitar + "</li>");
				out.println("		<li>Secreto: " + secreto + "</li>");
				out.println("		</ul>");

				out.println("	</body>");
				out.println("</html>");
		}
		} else {
			/* errores.forEach(error -> out.println("<li>" + error + "</li>"));
			out.println("<p> <a href=\"/webapp-tarea1/form.jsp\"> volver </a> </p>");*/
			req.setAttribute("errores", errores);
			getServletContext().getRequestDispatcher("/index.jsp")
					.forward(req, resp);

		}
	}
}
