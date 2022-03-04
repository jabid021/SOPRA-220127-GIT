package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Compte;
import model.Vehicule;
import util.Context;

@WebServlet("/vehicule")
public class VehiculeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//findAll()
		if(request.getParameter("id")==null) {
			List<Vehicule> vehicules=Context.getSingleton().getDaoVehicule().findAll();
			request.setAttribute("listeVehicule", vehicules);
			getServletContext().getRequestDispatcher("/WEB-INF/vehicule.jsp").forward(request, response);
		}
		//findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Vehicule v = Context.getSingleton().getDaoVehicule().findById(id);
			request.setAttribute("vehicule", v);
			getServletContext().getRequestDispatcher("/WEB-INF/updateVehicule.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("insert")) 
		{
			Vehicule v = new Vehicule(request.getParameter("modele"));
			Context.getSingleton().getDaoVehicule().insert(v);
		}
		else if(request.getParameter("tache").equals("update")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Vehicule v = new Vehicule(id,request.getParameter("modele"));
			Context.getSingleton().getDaoVehicule().update(v);
		}
		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoVehicule().delete(id);
		}

		response.sendRedirect("vehicule");
	}

}
