package com.svillanueva.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		LocalDateTime fecha = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd 'de' MMMM, yyyy");


		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");

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
		printWriter.println("		<h1>Tarea 1: Servlet y envío de parámetros<h1/>");

		if (nombre != null && apellido != null) {
			printWriter.println("		<h2> Hola mi nombre es: " + nombre + apellido + "</h2>");
		} else {
			printWriter.println("		<h1>No Existen los datos</h1>");
		}
		printWriter.println("<h3>La fecha actual es: " + formato.format(fecha) + "</h3>");

		printWriter.println("	</body>");
		printWriter.println("</html>");
		printWriter.close();
	}
}
