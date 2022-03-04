package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.Compte;
import model.Staff;
import util.Context;

@WebServlet("/home")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ici");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		Compte connected=Context.getSingleton().getDaoCompte().seConnecter(mail,password);
		
		if(connected instanceof Client) {response.sendRedirect("client.html");}

		else if(connected instanceof Staff) {response.sendRedirect("staff.html");}

		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		


	}
	

}
