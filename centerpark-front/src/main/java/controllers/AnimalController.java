package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Client;
import model.Ecureuil;
import model.Sanglier;
import model.Serpent;
import util.Context;

@WebServlet("/animal")
public class AnimalController extends HttpServlet {

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
			Animal a = Context.getSingleton().getDaoAnimal().findById(id);
			request.setAttribute("animal", a);
		}
		
		getServletContext().getRequestDispatcher("/updateAnimal.jsp").forward(request, response);
	}

	//Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("tache").equals("insert")) 
		{
			if(request.getParameter("typeAnimal").equals("Sanglier")) 
			{
				
				Sanglier sg = new Sanglier(request.getParameter("nom"));
				Context.getSingleton().getDaoAnimal().insert(sg);
			}
			else if(request.getParameter("typeAnimal").equals("Serpent")) 
			{
				Serpent sp = new Serpent(request.getParameter("nom"));
				Context.getSingleton().getDaoAnimal().insert(sp);
			}
			else if(request.getParameter("typeAnimal").equals("Ecureuil")) 
			{
				Ecureuil ec = new Ecureuil(request.getParameter("nom"));
				Context.getSingleton().getDaoAnimal().insert(ec);
			}
		
		}
		
		else if(request.getParameter("tache").equals("update")) 
		{
	
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(request.getParameter("typeAnimal").equals("Sanglier")) 
			{
				Sanglier sg = new Sanglier(id,request.getParameter("nom"));
				Context.getSingleton().getDaoAnimal().update(sg);
			}
			else if(request.getParameter("typeAnimal").equals("Serpent")) 
			{
				Serpent sp = new Serpent(id,request.getParameter("nom"));
				Context.getSingleton().getDaoAnimal().update(sp);
			}
			else if(request.getParameter("typeAnimal").equals("Ecureuil")) 
			{
				Ecureuil ec = new Ecureuil(id,request.getParameter("nom"));
				Context.getSingleton().getDaoAnimal().update(ec);
			}
			System.out.println(request.getParameter("id"));
			
		}
		
		else if(request.getParameter("tache").equals("delete"))
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoAnimal().delete(id);
		}
		
		response.sendRedirect("animaux.jsp");
	
	}

}
