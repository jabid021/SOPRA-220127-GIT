package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.Staff;
import util.Context;

@WebServlet("/compte")
public class CompteController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//findAll()
		if(request.getParameter("id")==null) 
		{
			System.out.println("findall");
		}
		//findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Client c = (Client)Context.getSingleton().getDaoCompte().findById(id);
			request.setAttribute("client", c);
		}
		
		getServletContext().getRequestDispatcher("/updateClient.jsp").forward(request, response);
	}

	//Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("1");
		
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
			
		}
		
		else if(request.getParameter("tache").equals("update")) 
		{
			System.out.println("2");
			int id = Integer.parseInt(request.getParameter("id"));
			if(request.getParameter("typeCompte").equals("client")) 
			{
				System.out.println("3");
				Client c = new Client(id,request.getParameter("mail"),request.getParameter("password"),request.getParameter("tel"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"));
				Context.getSingleton().getDaoCompte().update(c);
				System.out.println(c);
			}
			else if(request.getParameter("typeCompte").equals("staff"))
			{
				Staff s = new Staff(id,request.getParameter("mail"),request.getParameter("password"),request.getParameter("metier"));
				Context.getSingleton().getDaoCompte().update(s);
			}
		}
		
		else if(request.getParameter("tache").equals("delete"))
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoCompte().delete(id);
		}
		
		response.sendRedirect("comptes.jsp");
	
	}

}
