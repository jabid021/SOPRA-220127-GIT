package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
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
			Animal a = new Animal(request.getParameter("nom"),request.getParameter("type"));
			Context.getSingleton().getDaoAnimal().insert(a);
		
		}
		
		else if(request.getParameter("tache").equals("update")) 
		{
	
			int id = Integer.parseInt(request.getParameter("id"));
			Animal a = new Animal(id,request.getParameter("nom"),request.getParameter("type"));
			Context.getSingleton().getDaoAnimal().update(a);
		}
		
		else if(request.getParameter("tache").equals("delete"))
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoAnimal().delete(id);
		}
		
		response.sendRedirect("animaux.jsp");
	
	}

}
