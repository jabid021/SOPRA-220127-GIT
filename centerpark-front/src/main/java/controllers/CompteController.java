package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.Compte;
import model.Staff;
import util.Context;

@WebServlet("/compte")
public class CompteController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Compte> comptes=Context.getSingleton().getDaoCompte().findAll();
			request.setAttribute("listeCompte", comptes);
			System.out.println(comptes);
			getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp").forward(request, response);
		}
		//findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Compte compte = Context.getSingleton().getDaoCompte().findById(id);
			if(compte instanceof Client) 
			{
				Client c = (Client) compte;
				request.setAttribute("client", c);
				getServletContext().getRequestDispatcher("/WEB-INF/updateClient.jsp").forward(request, response);
			}
			else if(compte instanceof Staff) {
				Staff s = (Staff) compte;
				request.setAttribute("staff", s);
				getServletContext().getRequestDispatcher("/WEB-INF/updateStaff.jsp").forward(request, response);
			}
			
			
		}

		

	}


	//Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("insert")) 
		{
			if(request.getParameter("typeCompte").equals("client")) 
			{

				Client c = new Client(request.getParameter("mail"),request.getParameter("password"),request.getParameter("tel"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"));
				Context.getSingleton().getDaoCompte().insert(c);
			}
			else if(request.getParameter("typeCompte").equals("staff"))
			{
				Staff s = new Staff(request.getParameter("mail"),request.getParameter("password"),request.getParameter("metier"));
				Context.getSingleton().getDaoCompte().insert(s);
			}
			response.sendRedirect("compte");
		}

		else if(request.getParameter("tache").equals("update")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			if(request.getParameter("typeCompte").equals("client")) 
			{
				Client c = new Client(id,request.getParameter("mail"),request.getParameter("password"),request.getParameter("tel"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"));
				Context.getSingleton().getDaoCompte().update(c);
			}
			else if(request.getParameter("typeCompte").equals("staff"))
			{
				Staff s = new Staff(id,request.getParameter("mail"),request.getParameter("password"),request.getParameter("metier"));
				Context.getSingleton().getDaoCompte().update(s);
				
			}
			
			//sinon c'est le staff qui fait une modif
			if(request.getSession().getAttribute("connected")!=null) 
			{
				response.sendRedirect("compte");
			}
			
			//Si on est pas encore connecté, c'est une inscription
			else {
				response.sendRedirect("home");
			}
			
		}

		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoCompte().delete(id);
			response.sendRedirect("compte");
		}

		


	}

}
