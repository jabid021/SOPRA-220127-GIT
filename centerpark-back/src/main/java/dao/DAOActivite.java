package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Activite;
import model.Aquatique;
import model.Client;
import model.Compte;
import model.Meteo;
import model.Safari;
import model.Staff;
import model.Vehicule;

public class DAOActivite implements IDAO<Activite, Integer> {

	static DAOVehicule daoVehicule = new DAOVehicule();

	@Override
	public Activite findById(Integer id) {

		Activite a = null;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centerpark","root","");
			PreparedStatement ps = conn.prepareStatement("SELECT * from activite left join safari on safari.activite_fk=id_activite where id_activite = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				if (rs.getObject("vehicule_fk")!=null)
				{
					Vehicule v = daoVehicule.findById(rs.getInt("vehicule_fk"));
					a = new Safari(rs.getInt("id_activite"), Meteo.valueOf(rs.getString("meteo")),
							LocalDate.parse(rs.getString("date_activite")),
							LocalTime.parse(rs.getString("heure_activite")),
							rs.getDouble("prix"), v,null);
				} else {
					a = new Aquatique(rs.getInt("id_activite"), Meteo.valueOf(rs.getString("meteo")),
							LocalDate.parse(rs.getString("date_activite")),
							LocalTime.parse(rs.getString("heure_activite")),
							rs.getDouble("prix"));
				}


			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public List<Activite> findAll() {
		List<Activite> aList = new ArrayList<Activite>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centerpark","root","");
			PreparedStatement ps = conn.prepareStatement("SELECT * from activite left join safari on safari.activite_fk=id_activite");

			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				Activite a;
				if (rs.getObject("vehicule_fk")!=null)
				{
					Vehicule v = daoVehicule.findById(rs.getInt("vehicule_fk"));
					a = new Safari(rs.getInt("id_activite"), Meteo.valueOf(rs.getString("meteo")),
							LocalDate.parse(rs.getString("date_activite")),
							LocalTime.parse(rs.getString("heure_activite")),
							rs.getDouble("prix"), v,null);
				} else {
					a = new Aquatique(rs.getInt("id_activite"), Meteo.valueOf(rs.getString("meteo")),
							LocalDate.parse(rs.getString("date_activite")),
							LocalTime.parse(rs.getString("heure_activite")),
							rs.getDouble("prix"));
				}

				aList.add(a);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return aList;
	}

	@Override
	public Activite insert(Activite c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centerpark","root","");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO activite (date_activite,heure_activite,prix,meteo) VALUES (?,?,?,?)");

			ps.setString(1, c.getDate().toString());
			ps.setString(2, c.getHeure().toString());
			ps.setDouble(3, c.getPrix());
			ps.setString(4,c.getMeteo().toString());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Activite a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centerpark","root","");
			PreparedStatement ps = conn.prepareStatement("UPDATE activite SET date_activite= ? ,heure_activite= ?,prix=?,meteo=? where id_activite = ?");

			ps.setString(1, a.getDate().toString());
			ps.setString(2, a.getHeure().toString());
			ps.setDouble(3, a.getPrix());
			ps.setString(4, a.getMeteo().toString());
			ps.setInt(5, a.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centerpark","root","");
			PreparedStatement ps = conn.prepareStatement("DELETE FROM activite WHERE id_activite=?");
			ps.setInt(1,id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public List<Activite> findAllDisponibles() {
		List<Activite> aList = new ArrayList<Activite>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centerpark","root","");
			PreparedStatement ps = conn.prepareStatement("SELECT * from activite left join safari on safari.activite_fk=id_activite where date_activite> now()");

			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				Activite a;
				if (rs.getObject("vehicule_fk")!=null)
				{
					Vehicule v = daoVehicule.findById(rs.getInt("vehicule_fk"));
					a = new Safari(rs.getInt("id_activite"), Meteo.valueOf(rs.getString("meteo")),
							LocalDate.parse(rs.getString("date_activite")),
							LocalTime.parse(rs.getString("heure_activite")),
							rs.getDouble("prix"), v,null);
				} else {
					a = new Aquatique(rs.getInt("id_activite"), Meteo.valueOf(rs.getString("meteo")),
							LocalDate.parse(rs.getString("date_activite")),
							LocalTime.parse(rs.getString("heure_activite")),
							rs.getDouble("prix"));
				}

				aList.add(a);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return aList;
	}


}