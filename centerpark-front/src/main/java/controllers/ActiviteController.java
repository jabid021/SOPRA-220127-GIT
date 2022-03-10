package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Activite;
import model.Aquatique;
import model.Meteo;
import model.Safari;
import model.Vehicule;
import util.Context;

@WebServlet("/activite")
public class ActiviteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Vehicule> vehicules = Context.getSingleton().getDaoVehicule().findAll();
		Meteo[] meteos = Meteo.values();
		request.setAttribute("vehicules", vehicules);
		request.setAttribute("meteos", meteos);
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Activite> activites = Context.getSingleton().getDaoActivite().findAll();
			
			request.setAttribute("activites", activites);
			getServletContext().getRequestDispatcher("/WEB-INF/activite.jsp").forward(request, response);

			
			
		}
		//findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Activite a = Context.getSingleton().getDaoActivite().findById(id);
			request.setAttribute("activite", a);
			getServletContext().getRequestDispatcher("/WEB-INF/updateActivite.jsp").forward(request, response);
		}

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("insert")) 
		{
			System.out.println("insert");
			if(request.getParameter("typeActivite").equals("aquatique")) 
			{
				
				Aquatique a = new Aquatique(Meteo.valueOf(request.getParameter("meteo")),LocalDate.parse(request.getParameter("date")),LocalTime.parse(request.getParameter("heure")),Double.parseDouble(request.getParameter("prix")));
				Context.getSingleton().getDaoActivite().insert(a);
				
				System.out.println(a.toString());
				System.out.println("id "+a.getId());
				
				System.out.println("id activite "+a.getId());
				Context.getSingleton().getDaoActivite().insertAquatique(a);
			}
			else if(request.getParameter("typeActivite").equals("safari"))
			{
				System.out.println(Arrays.toString(request.getParameterValues("vehicule")));
				int id = Integer.parseInt(request.getParameter("vehicule"));
				Vehicule v = Context.getSingleton().getDaoVehicule().findById(id);
				System.out.println(v.toString());
				Safari s = new Safari(Meteo.valueOf(request.getParameter("meteo")),LocalDate.parse(request.getParameter("date")),LocalTime.parse(request.getParameter("heure")),Double.parseDouble(request.getParameter("prix")),v,null);
				System.out.println(s.toString());
				Context.getSingleton().getDaoActivite().insert(s);
				
				System.out.println(s.getId()+" "+ s.getVehicule().getId());
				Context.getSingleton().getDaoActivite().insertSafari(s);

			}
			
			
		}

		else if(request.getParameter("tache").equals("update")) 
		{
			System.out.println("update");
			System.out.println(request.getParameter("typeActivite"));
			
			if(request.getParameter("typeActivite").equals("Aquatique")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				int version = Integer.parseInt(request.getParameter("version"));
				System.out.println("aquatique");
				Aquatique a = new Aquatique(id,Meteo.valueOf(request.getParameter("meteo")),LocalDate.parse(request.getParameter("date")),LocalTime.parse(request.getParameter("heure")),Double.parseDouble(request.getParameter("prix")));
				a.setVersion(version);
				Context.getSingleton().getDaoActivite().update(a);
				System.out.println(a);
			}
			else if(request.getParameter("typeActivite").equals("Safari"))
			{
				System.out.println("on est dans safari");
				int id_safari = Integer.parseInt(request.getParameter("id"));
				int version = Integer.parseInt(request.getParameter("version"));
				int id_vehicule = Integer.parseInt(request.getParameter("vehicule"));
				
				Vehicule v = Context.getSingleton().getDaoVehicule().findById(id_vehicule);

				Safari s = new Safari(id_safari,Meteo.valueOf(request.getParameter("meteo")),LocalDate.parse(request.getParameter("date")),LocalTime.parse(request.getParameter("heure")),Double.parseDouble(request.getParameter("prix")),v,null);
				s.setVersion(version);
				Context.getSingleton().getDaoActivite().update(s);

			}
		}

		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));


			Context.getSingleton().getDaoActivite().delete(id);
		}


		response.sendRedirect("activite");


	}


}


